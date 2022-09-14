package com.spring.processor.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: MyBeanPostProcessor
 * - @Author: WangJiLIn
 * - Description:  BeanPostProcessor后置处理器可扩展
 * 接⼝描述
 * - Functions:
 * * BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * *
 * * 1、BeanFactoryPostProcessor：beanFactory的后置处理器；
 * * 在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 * * 所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 * - History:
 * Date        Author          Modification
 * 2022/6/8   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor , PriorityOrdered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexDao")){
			System.out.println("MyBeanPostProcessor======postProcessBeforeInitialization");
		}
		return bean;
//		Proxy.newProxyInstance()
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("indexDao")){
			System.out.println("MyBeanPostProcessor======postProcessAfterInitialization");
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
