package com.wzg.hello.spring.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName SpringUtil
 * @Description 获取行下文时必须注意spring的生命周期
 * @Author wzg
 * Date 2020/11/19 17:09
 * Version 1.0
 */
public final class SpringUtil {
    private SpringUtil() {
    }

    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

    public static Object getBean(String beanId) {
        return context.getBean(beanId);
    }
}
