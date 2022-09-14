package com.wjl;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: User
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
public class User {
	private String name;

	public User(String s) {
		this.name=s;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
}
