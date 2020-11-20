package com.wzg.test.my.shop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LoginFilter
 * @Description 登录拦截器判断是否登录
 * @Author wzg
 * Date 2020/11/20 10:04
 * Version 1.0
 */
public class LoginFilter implements Filter {

    private static List<String> pattenURL = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession();
        // 登陆url
        String loginUrl = httpRequest.getContextPath() + "/login.html";
        String url = httpRequest.getRequestURI();

        /*
         * 注：在pattenURL中的全部不拦截
         * url.indexOf(urlStr) > -1  表示urlStr在url中出现过，出现就不拦截
         * */
        for (String urlStr : pattenURL) {
            if(url.indexOf(urlStr) > -1){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        /*
         * 超时处理，ajax请求超时设置超时状态，页面请求超时则返回提示并重定向
         * session.getAttribute("")是获取到登录人的session信息
         * */
        String loginFlag = (String) session.getAttribute("login");
        if (loginFlag == null || !"1".equals(loginFlag)) {
            // 判断是否为ajax请求
            if (httpRequest.getHeader("x-requested-with") != null
                    && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                //返回超时标识
                httpResponse.addHeader("sessionstatus", "timeOut");
                // 返回url
                httpResponse.addHeader("loginPath", loginUrl);
                // 不可少，否则请求会出错
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //alert('会话过期,请重新登录');
                String str = "<script language='javascript'>"
                        + "window.top.location.href='"
                        + loginUrl
                        + "';</script>";
                // 解决中文乱码
                servletResponse.setContentType("text/html;charset=UTF-8");
                try {
                    PrintWriter writer = servletResponse.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //登录jsp
        pattenURL.add("login.html");
        //登录方法
        pattenURL.add("/servlet/login");
        //发送验证码方法
        pattenURL.add("sendCode.do");
        pattenURL.add("css");
        pattenURL.add("image");
        pattenURL.add("js");
        pattenURL.add("fonts");
        pattenURL.add("png");

    }

    @Override
    public void destroy() {

    }
}
