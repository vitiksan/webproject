package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created by on 17.09.2017.
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Cookie loginCookie = new Cookie("login",login);
        loginCookie.setMaxAge(600);
        Cookie passwordCookie = new Cookie("password",password);
        passwordCookie.setMaxAge(600);
        response.addCookie(loginCookie);
        response.addCookie(passwordCookie);
        response.sendRedirect("/ProfileServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("login-page.jsp").forward(request, response);
    }
}
