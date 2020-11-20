package com.wzg.login.demo.entity;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author wzg
 * Date 2020/10/14 20:34
 * Version 1.0
 */
public class User implements Serializable {
    /** 用户名 **/
    private String userName;
    /** 登录id **/
    private String loginId;
    /** 登录密码 **/
    private String loginPwd;

    public User() {
    }

    public User(String userName, String loginId, String loginPwd) {
        this.userName = userName;
        this.loginId = loginId;
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", loginId='" + loginId + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }
}
