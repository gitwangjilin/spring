package com.spring.processor.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*************************************************************************
 ******
 * - Copyright (c) 2022 shangzhao.com
 * - File Name: ApplicationListener
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 ** 3、ApplicationListener：监听容器中发布的事件。事件驱动模型开发；
 * * public interface ApplicationListener<E extends ApplicationEvent>
 * * 监听 ApplicationEvent 及其下面的子事件；
 * *
 * * 步骤：
 * * 1）、写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）
 * * @EventListener;
 * * 原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener；
 * *
 * * 2）、把监听器加入到容器；
 * * 3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 * * ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件；
 * * ContextClosedEvent：关闭容器会发布这个事件；
 * * 4）、发布一个事件：
 * * applicationContext.publishEvent()；
 * - History:
 * Date        Author          Modification
 * 2022/6/11   WangJiLin     Create the current class
 *************************************************************************
 ******/
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	//当容器中发布此事件以后，方法触发
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("收到事件："+event);
	}
}