package com.wzg.hello.maven.servlet;

import com.wzg.hello.maven.servlet.utils.TestInterface;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HelloServlet
 * @Description TODO
 * @Author wzg
 * Date 2020/10/14 16:32
 * Version 1.0
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestInterface.test2();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
