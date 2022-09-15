package com.wirtespring.app.service;


import com.wirtespring.spring.BeanPostProcessor;
import com.wirtespring.spring.Component;

import java.lang.reflect.Field;

/**
 * @author 周瑜
 */
@Component
public class TestValueBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(TestValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, field.getAnnotation(TestValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // bean
        return bean;
    }
}
