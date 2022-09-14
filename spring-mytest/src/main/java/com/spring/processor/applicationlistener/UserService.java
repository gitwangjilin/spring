package com.spring.processor.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

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
 * 2022/6/11   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Service
public class UserService {

	@EventListener(classes={ApplicationEvent.class})
	public void listen(ApplicationEvent event){
		System.out.println("UserService。。监听到的事件："+event);
	}
}
