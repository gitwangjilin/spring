package com.wirtespring.app;

import com.wirtespring.app.service.OrderService;
import com.wirtespring.app.service.UserInterface;
import com.wirtespring.app.service.UserService;
import com.wirtespring.spring.ApplicationContext;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: Text
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
public class Text {
	public static void main(String[] args) {
		//创建单利bean
		ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
		UserInterface userService = (UserInterface) applicationContext.getBean("userService");
		userService.test();
		OrderService orderService = (OrderService) applicationContext.getBean("orderService");
		orderService.test();

	}
}
