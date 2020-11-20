package com.wzg.login.demo.dao.impl;

import com.wzg.login.demo.dao.UserDao;
import com.wzg.login.demo.entity.User;

/**
 * @ClassName UserDaoImpl
 * @Description 用户数据交互
 * @Author wzg
 * Date 2020/10/14 20:46
 * Version 1.0
 */
public class UserDaoImpl implements UserDao {

    /** 获取userDao对象 **/
    private static UserDao userDao = null;

    /**
     * 单例模式，使用双重加锁保证线程安全
     * @return
     */
    public static UserDao getUserDao(){
        if (userDao == null) {
            synchronized (UserDaoImpl.class) {
                if (userDao == null) {
                    userDao = new UserDaoImpl();
                }
            }
        }
        return userDao;
    }

    /**
     * 获取用户信息
     * @param loginId 登录id
     * @return 用户信息
     */
    public User getUser(String loginId) {
        if ("admin".equals(loginId)) {
            return new User("管理员", "admin", "admin");
        }
        return null;
    }
}
