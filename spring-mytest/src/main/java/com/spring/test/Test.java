package com.spring.test;

import com.spring.config.AppConfig;
import com.spring.dao.IndexDao;
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
		//把Spring的所有的前提环境准备
		//注释     配置   应用背景信息
		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(AppConfig.class);
//		AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext();
//		annotation.register(IndexDao.class);
//		annotation.refresh();
//		IndexDao bean = annotation.getBean(IndexDao.class);
		IndexDao bean = (IndexDao) annotation.getBean("indexDao");
		bean.indexDao();
	}
}

