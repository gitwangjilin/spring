package com.factorybean.test;

import com.factorybean.bean.MyFactoryBean;
import com.factorybean.bean.TestFacroryBean;
import com.factorybean.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Test
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
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(AppConfig.class);

		TestFacroryBean myFactoryBean = (TestFacroryBean) annotation.getBean("myFactoryBean");
		myFactoryBean.testFacetBean();

		MyFactoryBean myBean = (MyFactoryBean) annotation.getBean("&myFactoryBean");
		myBean.testBean();

	}
}
