package com.wzg.hello.spring;

import com.wzg.hello.spring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test
 * @Description 测试
 * @Author wzg
 * Date 2020/10/18 15:17
 * Version 1.0
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.sayHi();

        logger.info("info级别日志");
        logger.debug("debug级别日志");

        String message1 = "测试1";
        String message2 = "测试2";

        //一句Java中字符串的特性使用+号将生成对象
        //下面这两种方式可以降低这种消耗
        logger.info("message is : {} {}", message1, message2);
        System.out.println(String.format("message is : %s %s", message1, message2));
    }
}
