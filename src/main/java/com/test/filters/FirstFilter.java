package com.test.filters;// Created by on 20.09.2017.

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Enter in first filter");
        servletRequest.setAttribute("message", "go away bastard");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Exit from first filter");
    }
}
