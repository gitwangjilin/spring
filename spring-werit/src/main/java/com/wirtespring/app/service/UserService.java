package com.wirtespring.app.service;

import com.wirtespring.spring.Autowired;
import com.wirtespring.spring.BeanNameAware;
import com.wirtespring.spring.Component;
import com.wirtespring.spring.Scope;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: UserService
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/14   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component("userService")
public class UserService implements UserInterface, BeanNameAware {

	@Autowired
	private OrderService orderService;

//	@TestValue("xxx")
//	private String test;


	private String beanName;

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

	@Override
	public void test() {
		System.out.println(beanName);
	}
}
