package com.wzg.hello.spring.service.impl;

import com.wzg.hello.spring.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description 测试依赖注入
 * @Author wzg
 * Date 2020/10/18 15:16
 * Version 1.0
 */
public class UserServiceImpl implements UserService {

    public void sayHi() {
        System.out.println("hi spring");
    }
}
