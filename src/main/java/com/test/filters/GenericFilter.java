package com.test.filters;// Created by on 20.09.2017.

import javax.servlet.*;
import java.io.IOException;

public class GenericFilter implements javax.servlet.Filter {
    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
