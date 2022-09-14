package com.spring.classinit;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: PostConstructInit
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2022/9/9   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class PostConstructInit {
	@PostConstruct
	public void init(){
		System.out.println("====PostConstruct====");
	}
}
