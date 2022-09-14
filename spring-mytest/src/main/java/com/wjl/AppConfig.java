package com.wjl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: AppConfig
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
@Configuration
@ComponentScan
public class AppConfig {
	@Bean
	public User testBean() {
		return new User("12");
	}
}
