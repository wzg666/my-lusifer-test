package com.wzg.test.my.shop.dao.impl;

import com.wzg.test.my.shop.dao.UserDao;
import com.wzg.test.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName UserDaoImpl
 * @Description 用户数据层
 * @Author wzg
 * Date 2020/11/19 11:50
 * Version 1.0
 */
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    /**
     * 依据用户名和密码获取用户
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        User user = null;
        if ("admin".equals(userName)) {
            user = new User();
            user.setEmail("admin@163.com");
            user.setUserName("admin");
            user.setPassWord("admin");
        }
        return user;
    }

    /**
     * 依据邮箱和密码获取用户
     * @param email
     * @return
     */
    @Override
    public User getUserByEmail(String email) {
        logger.debug("获取邮箱为:{} 的用户", email);
        User user = null;
        if ("admin@163.com".equals(email)) {
            user = new User();
            user.setEmail("admin@163.com");
            user.setUserName("admin");
            user.setPassWord("admin");
        }
        return user;
    }
}
