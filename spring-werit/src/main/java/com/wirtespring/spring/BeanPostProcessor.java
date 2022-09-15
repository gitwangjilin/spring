package com.wirtespring.spring;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: BeanPostProcessor
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/15   WangJiLin     Create the current class
 *************************************************************************
 ******/
public interface BeanPostProcessor {
	default Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean;
	}

	default Object postProcessAfterInitialization(Object bean, String beanName) {
		return bean;
	}
}
