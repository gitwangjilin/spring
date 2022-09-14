package com.wjl;

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
 * 2022/6/5   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotation =new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("========");
		User bean = (User) annotation.getBean("testBean");
		System.out.println(bean);
	}
}
