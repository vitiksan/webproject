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
        String login = "";
        String password = "";
        boolean isLogin = false;
        HttpSession session = request.getSession();
        Enumeration<String> names = request.getSession().getAttributeNames();
        login = (String) session.getAttribute("login");
        password = (String) session.getAttribute("password");

        /*Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("login")) {
                login = cookies[i].getValue();
                isLogin = true;
            } else if (cookies[i].getName().equals("password"))
                password = cookies[i].getValue();
        }*/
        if (!login.equals("")) {
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
        } else {
            writer.print("<h1 align=\"center\">You must login before</h1>");
            request.getRequestDispatcher("login-page.jsp").include(request, response);
        }
    }
}
