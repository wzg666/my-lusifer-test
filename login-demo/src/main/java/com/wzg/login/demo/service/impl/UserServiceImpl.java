package com.wzg.login.demo.service.impl;

import com.wzg.login.demo.dao.UserDao;
import com.wzg.login.demo.dao.impl.UserDaoImpl;
import com.wzg.login.demo.entity.User;
import com.wzg.login.demo.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务处理
 * @Author wzg
 * Date 2020/10/14 20:54
 * Version 1.0
 */
public class UserServiceImpl implements UserService {

    /** 获取userService对象 **/
    private static UserService userService;

    /**
     * 单例模式，使用双重加锁保证线程安全
     * @return
     */
    public static UserService getUserService() {
        if (userService == null) {
            synchronized (UserServiceImpl.class) {
                if (userService == null) {
                    userService = new UserServiceImpl();
                }
            }
        }
        return userService;
    }

    /**
     * 用户登录
     * @param user 用户信息
     * @return 登录成功失败
     */
    public boolean login(User user) {
        if (user == null || user.getLoginId() == null) {
            return false;
        }
        User realUser = UserDaoImpl.getUserDao().getUser(user.getLoginId());
        if (realUser.getLoginPwd() != null && realUser.getLoginPwd().equals(user.getLoginPwd())) {
            return true;
        }
        return false;
    }

    /**
     * 用户登录
     * @param loginId 登录id
     * @param loginPwd 登录密码
     * @return 登录成功失败
     */
    public boolean login(String loginId, String loginPwd) {
        return login(new User("", loginId, loginPwd));
    }
}
