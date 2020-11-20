package com.wzg.login.demo.dao;

import com.wzg.login.demo.entity.User;

/**
 * @ClassName UserDao
 * @Description 用户数据交互
 * @Author wzg
 * Date 2020/10/14 20:41
 * Version 1.0
 */
public interface UserDao {

    /**
     * 获取用户信息
     * @param loginId 登录id
     * @return 用户信息
     */
    public User getUser(String loginId);
}
