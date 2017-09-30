package com.test.filters;// Created by on 30.09.2017.

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class LoggingFilter extends GenericFilter {
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

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            this.context.log(request.getRemoteAddr() + "::Parameter name - " +
                    parameterName + " parameter value - " + parameterValue);
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                String cookieName = cookies[i].getName();
                String cookieValue = cookies[i].getValue();
                this.context.log(request.getRemoteAddr() + "::Cookie name - " +
                        cookieName + " cookie value - " + cookieValue);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
