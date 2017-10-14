package com.test.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

// Created by on 17.09.2017.
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //HttpSession session = request.getSession();
        String login = (String) request.getAttribute("login");
        String password = (String) request.getAttribute("password");
        writer.print("<html><head><title>Profile page</title></head>" +
                "<body link=\"#00008b\" vlink=\"#00008b\" alink=\"#dc143c\">" +
                "<div align=\"center\">" +
                "    <h2><a style=\"text-decoration: none; margin: 5px\" href=\"/LoginServlet\">Login</a>" +
                "    <a style=\"text-decoration: none; margin: 5px\" href=\"/LogoutServlet\">Logout</a>" +
                "    <a style=\"text-decoration: none; margin: 5px\" href=\"/ProfileServlet\">Profile</a></h2>" +
                "</div><hr>" +
                "<h1 align=\"center\">Your profile</h1>" +
                "<div align=\"center\">" +
                "<p>User name: " + login + "<br>" +
                "User password: " + password + "</p>" +
                "</div>" +
                "</body></html>");
    }
}
