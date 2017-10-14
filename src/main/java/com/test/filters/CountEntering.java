package com.test.filters;// Created by on 14.10.2017.

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CountEntering extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
            session.setAttribute("login", 0);
            session.setAttribute("logout", 0);
            session.setAttribute("profile", 0);
        }
        String path = request.getRequestURI();
        if (path.endsWith("login-page.jsp") || path.endsWith("LoginServlet")) {
            Integer curCount = (Integer) session.getAttribute("login");
            session.setAttribute("login", curCount + 1);
        } else if (path.endsWith("LogoutServlet")) {
            Integer curCount = (Integer) session.getAttribute("logout");
            session.setAttribute("logout", curCount + 1);
        } else if (path.endsWith("ProfileServlet")) {
            Integer curCount = (Integer) session.getAttribute("profile");
            session.setAttribute("profile", curCount + 1);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
