package com.test.filters;// Created by on 05.10.2017.

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EncryptDecryptFilter extends GenericFilter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("Initialization logging filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String login = context.getInitParameter("login");
        String password = context.getInitParameter("password");
        String hashLogin = (String) session.getAttribute("login");
        String hashPassword = (String) session.getAttribute("password");

        if (DigestUtils.md5Hex(login).equals(hashLogin) &&
                DigestUtils.md5Hex(password).equals(hashPassword)) {
            request.setAttribute("login", login);
            request.setAttribute("password", password);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
