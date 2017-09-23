package com.test.filters;// Created by on 23.09.2017.

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AutorizationFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Enter into autorization servlet");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();

        try {
            if (!session.getAttribute("login").equals(null)) {
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println("Exit");
            }
        } catch (NullPointerException e) {
            PrintWriter writer = servletResponse.getWriter();
            writer.print("<h1 align=\"center\">You must login before</h1>");
            servletRequest.getRequestDispatcher("login-page.jsp").
                    include(servletRequest, servletResponse);
            System.out.println("Route to login page and exit");
        }
    }
}
