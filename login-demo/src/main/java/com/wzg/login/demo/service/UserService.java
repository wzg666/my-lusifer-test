package com.wzg.login.demo.service;

import com.wzg.login.demo.entity.User;

/**
 * @ClassName UserService
 * @Description 用户业务层
 * @Author wzg
 * Date 2020/10/14 20:52
 * Version 1.0
 */
public interface UserService {

    /**
     * 用户登录
     * @param user 用户信息
     * @return 登录成功失败
     */
    public boolean login(User user);

    /**
     * 用户登录
     * @param loginId 登录id
     * @param loginPwd 登录密码
     * @return 登录成功失败
     */
    public boolean login(String loginId, String loginPwd);
}
