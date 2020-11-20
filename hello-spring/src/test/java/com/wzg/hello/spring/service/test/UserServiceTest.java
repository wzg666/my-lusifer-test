package com.wzg.hello.spring.service.test;

import com.wzg.hello.spring.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @ClassName UserServiceTest
 * @Description 测试userService
 * @Author wzg
 * Date 2020/10/18 15:58
 * Version 1.0
 */
public class UserServiceTest {

    private UserService userService;

    @Before
    public void before() {
        System.out.println("初始化数据库连接");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = (UserService) applicationContext.getBean("userService");
    }

    @Test
    public void testSayHi() {
        userService.sayHi();
    }

    @After
    public void after() {
        System.out.println("关闭数据库连接");
    }

    @Test
    public void testAssert() {
        String str1 = "junit";
        String str2 = "junit";
        String str3 = "test";
        String str4 = "test";
        String str5 = null;
        int var1 = 1;
        int var2 = 2;
        int[] arithmetic1 = {1, 2, 3};
        int[] arithmetic2 = {1, 2, 3};

        assertEquals(str1, str2);

        assertSame(str3, str4);

        assertNotSame(str2, str4);

        assertNull(str5);

        assertTrue("为真", var1 != var2);

        assertArrayEquals(arithmetic1, arithmetic2);
    }
}
