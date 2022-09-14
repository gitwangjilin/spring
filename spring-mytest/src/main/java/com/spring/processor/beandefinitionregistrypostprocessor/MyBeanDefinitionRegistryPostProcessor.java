package com.spring.processor.beandefinitionregistrypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: BeanDefinitionRegistryPostProcessor
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 ** 原理：
 * * 1）、ioc创建对象
 * * 2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
 * * 3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
 * * 1、依次触发所有的postProcessBeanDefinitionRegistry()方法
 * * 2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；
 * *
 * * 4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法
 * - History:
 * Date        Author          Modification
 * 2022/6/11   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量："+beanFactory.getBeanDefinitionCount());
	}

	//BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeanDefinitionRegistry...bean的数量："+registry.getBeanDefinitionCount());
		//RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
//		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
//		registry.registerBeanDefinition("hello", beanDefinition);
	}

}