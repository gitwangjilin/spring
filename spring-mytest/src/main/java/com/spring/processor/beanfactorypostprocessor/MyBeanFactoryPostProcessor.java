package com.spring.processor.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: MyBeanFactorypostProcessor
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 * * BeanFactoryPostProcessor原理:
 * * 1)、ioc容器创建对象
 * * 2)、invokeBeanFactoryPostProcessors(beanFactory);
 * * 如何找到所有的BeanFactoryPostProcessor并执行他们的方法；
 * * 1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 * * 2）、在初始化创建其他组件前面执行
 * - History:
 * Date        Author          Modification
 * 2022/6/11   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor...postProcessBeanFactory...");
		int count = beanFactory.getBeanDefinitionCount();
		String[] names = beanFactory.getBeanDefinitionNames();
		System.out.println("当前BeanFactory中有"+count+" 个Bean");
		System.out.println(Arrays.asList(names));
	}

}