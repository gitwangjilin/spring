package com.wirtespring.spring;

import com.wirtespring.app.AppConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: ApplicationContext
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/14   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class ApplicationContext {

	private Class<AppConfig> configClass;
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	private Map<String, Object> singletonObjects = new HashMap<>();
	private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

	public ApplicationContext(Class<AppConfig> configClass) {
		this.configClass = configClass;

		// 扫描
		scan(configClass);

		for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
			String beanName = entry.getKey();
			BeanDefinition beanDefinition = entry.getValue();
			if (beanDefinition.getScope().equals("singleton")) {

				Object bean = createBean(beanName, beanDefinition);
				singletonObjects.put(beanName, bean);

			}
		}

	}

	/**
	 * 创建bean
	 *
	 * @param beanName
	 * @param beanDefinition
	 * @return
	 */
	private Object createBean(String beanName, BeanDefinition beanDefinition) {
		Class clazz = beanDefinition.getType();

		Object instance = null;
		try {

			instance = clazz.getConstructor().newInstance();

			for (Field field : clazz.getDeclaredFields()) {
				if (field.isAnnotationPresent(Autowired.class)) {

					field.setAccessible(true);

					field.set(instance, getBean(field.getName()));
				}
			}

			if (instance instanceof BeanNameAware) {
				((BeanNameAware) instance).setBeanName(beanName);
			}
			//遍历所有实现BeanPostProcessor并处理
			for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
				instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
			}

			//初始化实现
			if (instance instanceof InitializingBean) {
				((InitializingBean) instance).afterPropertiesSet();
			}

			for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
				instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
			}


		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		return instance;
	}

	/**
	 * 获取bean
	 *
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {

		if (!beanDefinitionMap.containsKey(beanName)) {
			throw new NullPointerException();
		}

		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		//获取bean判断是否单例，是直接拿，不是怎创建并加入实例化
		if (beanDefinition.getScope().equals("singleton")) {
			Object singletonBean = singletonObjects.get(beanName);
			if (singletonBean == null) {
				singletonBean = createBean(beanName, beanDefinition);
				singletonObjects.put(beanName, singletonBean);
			}
			return singletonBean;
		} else {
			// 原型
			Object prototypeBean = createBean(beanName, beanDefinition);
			return prototypeBean;
		}

	}


	private void scan(Class configClass) {
		//判断是是否有ComponentScan注解
		if (configClass.isAnnotationPresent(ComponentScan.class)) {
			ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
			String path = componentScanAnnotation.value();
			path = path.replace(".", "/");  //     com/zhouyu/service

			ClassLoader classLoader = ApplicationContext.class.getClassLoader();
			URL resource = classLoader.getResource(path);
			File file = new File(resource.getFile());

			if (file.isDirectory()) {
				for (File f : file.listFiles()) {
					String absolutePath = f.getAbsolutePath();

					absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
					absolutePath = absolutePath.replace("\\", ".");


					try {
						Class<?> clazz = classLoader.loadClass(absolutePath);

						if (clazz.isAnnotationPresent(Component.class)) {
							//扫描实现BeanPostProcessor存入List中
							if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
								BeanPostProcessor instance = (BeanPostProcessor) clazz.getConstructor().newInstance();
								beanPostProcessorList.add(instance);
							}else{
								//过滤已经实现的
							}

							Component componentAnnotation = clazz.getAnnotation(Component.class);
							String beanName = componentAnnotation.value();
							if ("".equals(beanName)) {
								beanName = Introspector.decapitalize(clazz.getSimpleName());
							}

							BeanDefinition beanDefinition = new BeanDefinition();
							beanDefinition.setType(clazz);

							if (clazz.isAnnotationPresent(Scope.class)) {
								Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
								String value = scopeAnnotation.value();
								beanDefinition.setScope(value);
							} else {
								beanDefinition.setScope("singleton");
							}

							beanDefinitionMap.put(beanName, beanDefinition);
						}
					} catch (ClassNotFoundException | NoSuchMethodException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}


				}
			}


		}
	}
}
