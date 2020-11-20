package com.wzg.test.my.shop.dao;

import com.wzg.test.my.shop.entity.User;

/**
 * @ClassName UserDao
 * @Description 用户数据层
 * @Author wzg
 * Date 2020/11/19 11:48
 * Version 1.0
 */
public interface UserDao {
    public User getUserByUserName(String userName);

    public User getUserByEmail(String email);
}
