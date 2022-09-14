package com.spring.processor.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: MyBeanPostProcessor
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/6/8   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyBeanPostProcessor1 implements BeanPostProcessor , PriorityOrdered {
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
	//类加载顺序，值越小越先执行
	@Override
	public int getOrder() {
		return 2;
	}
}
