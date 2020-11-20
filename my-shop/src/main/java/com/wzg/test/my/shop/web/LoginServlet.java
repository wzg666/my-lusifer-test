package com.wzg.test.my.shop.web;

import com.wzg.test.my.shop.common.util.SpringUtils;
import com.wzg.test.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginServlet
 * @Description 登录servlet
 * @Author wzg
 * Date 2020/11/19 14:49
 * Version 1.0
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = SpringUtils.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String passWord = req.getParameter("password");
        boolean flag = userService.login(email, passWord);
        System.out.println(String.format("user use email: %s,login %s", email, flag?"success":"fail"));
        if (flag) {
            HttpSession session = req.getSession();
            session.setAttribute("login", "1");
            resp.sendRedirect("/index.html");
        } else {
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }
    }
}
