package com.wzg.test.my.shop.service.impl;

import com.wzg.test.my.shop.common.util.SpringUtils;
import com.wzg.test.my.shop.dao.UserDao;
import com.wzg.test.my.shop.entity.User;
import com.wzg.test.my.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务层
 * @Author wzg
 * Date 2020/11/19 11:59
 * Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = SpringUtils.getBean("userDao");

    /**
     * 依据用户名取用户
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    /**
     * 依据邮箱获取用户
     * @param email
     * @return
     */
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    /**
     * 依据邮箱和密码登录
     * @param email
     * @param passWord
     * @return
     */
    @Override
    public boolean login(String email, String passWord) {
        boolean flag = false;
        if (StringUtils.isBlank(email)) {
            return false;
        }
        User user = userDao.getUserByEmail(email);
        if (user == null) {
        } else if (StringUtils.isBlank(passWord) && StringUtils.isBlank(user.getPassWord())) {
            flag = true;
        }else if (passWord.equals(user.getPassWord())) {
            flag = true;
        }
        return flag;
    }
}
