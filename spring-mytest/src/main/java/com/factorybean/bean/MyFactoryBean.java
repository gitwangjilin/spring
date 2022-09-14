package com.factorybean.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: MyBeanFactory
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
@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean<TestFacroryBean> {

	/**
	 * BeanFactory：生产和管理Bean的一个工厂接口，提供一个Spring IOC 容器规范
	 * FactoryBean：一个Bean创建的一种方式，可以对Bean进行扩展扩展可进行赋值对象创建细节等
	 * 获取当前FactoryBean需要加&符文
	 * 获取扩展，直接类名就可以
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public TestFacroryBean getObject() throws Exception {
		return new TestFacroryBean();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return FactoryBean.super.isSingleton();
	}

	public void testBean() {
		System.out.println("测试MyFactoryBean：" + MyFactoryBean.class);
	}

}
