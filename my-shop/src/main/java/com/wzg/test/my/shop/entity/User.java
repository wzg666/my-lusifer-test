package com.wzg.test.my.shop.entity;

/**
 * @ClassName User
 * @Description 用户
 * @Author wzg
 * Date 2020/11/19 11:44
 * Version 1.0
 */
public class User {
    private String userName;
    private String passWord;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
