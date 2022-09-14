package com.spring.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: IndexDao
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
@Component
public class IndexDao {
	public IndexDao(){
		System.out.println("构造");
	}
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	public void indexDao(){
		System.out.println("IndexDao===================");
	}
}
