package com.wzg.login.demo.web.controller;

import com.wzg.login.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @ClassName LoginController
 * @Description 登录处理器
 * @Author wzg
 * Date 2020/10/14 21:26
 * Version 1.0
 */
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(Charset.defaultCharset());
        System.out.println("=============================");
        System.out.println("登录验证开始");
        System.out.println("=============================");
        String loginId = req.getParameter("loginId");
        String loginPwd = req.getParameter("loginPwd");
        boolean loginFlag = UserServiceImpl.getUserService().login(loginId, loginPwd);
        System.out.println("=============================");
        System.out.println("登录验证结束");
        System.out.println("=============================");
        if (loginFlag) {
            //登录成功
            req.getRequestDispatcher("/hello.jsp").forward(req, resp);
        } else {
            //登陆失败
            req.getRequestDispatcher("/loginFail.jsp").forward(req, resp);
        }
    }
}
