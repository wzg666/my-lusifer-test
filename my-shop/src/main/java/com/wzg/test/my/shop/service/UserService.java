package com.wzg.test.my.shop.service;

import com.wzg.test.my.shop.entity.User;

/**
 * @ClassName UserService
 * @Description 用户业务层
 * @Author wzg
 * Date 2020/11/19 11:58
 * Version 1.0
 */
public interface UserService {
    public User getUserByUserName(String userName);

    public User getUserByEmail(String email);

    public boolean login(String email, String passWord);
}
