package com.wirtespring.spring;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: BeanDefinition
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
public class BeanDefinition {
	private Class type;
	private String scope;
	private boolean isLazy;

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public boolean isLazy() {
		return isLazy;
	}

	public void setLazy(boolean lazy) {
		isLazy = lazy;
	}
}