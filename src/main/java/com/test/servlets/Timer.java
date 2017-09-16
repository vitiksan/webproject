package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

// Created by on 09.09.2017.
@WebServlet(name = "Timer")
public class Timer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer hours = Integer.parseInt(request.getParameter("hours"));
        Integer minutes = Integer.parseInt(request.getParameter("minutes"));
        Integer seconds = Integer.parseInt(request.getParameter("seconds"));
        Cookie cookieHours = new Cookie("hours",hours.toString());
        cookieHours.setHttpOnly(true);
        Cookie cookieMinutes = new Cookie("minutes",minutes.toString());
        cookieMinutes.setHttpOnly(true);
        Cookie cookieSeconds = new Cookie("seconds",seconds.toString());
        cookieSeconds.setHttpOnly(true);
        response.addCookie(cookieHours);
        response.addCookie(cookieMinutes);
        response.addCookie(cookieSeconds);
        response.getWriter().print("<html>" +
                "<head>" +
                "<title>Loading</title>" +
                "</head><body>" +
                "<h2 align=\"center\">Loading...</h2>" +
                "</body>");
        response.setIntHeader("Refresh", 1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            if (names.nextElement().equals("back")){
                Cookie cookieHours = new Cookie("hours", "");
                cookieHours.setMaxAge(0);
                Cookie cookieMinutes = new Cookie("minutes", "");
                cookieMinutes.setMaxAge(0);
                Cookie cookieSeconds = new Cookie("seconds", "");
                cookieSeconds.setMaxAge(0);
                response.addCookie(cookieHours);
                response.addCookie(cookieMinutes);
                response.addCookie(cookieSeconds);
                RequestDispatcher dispatcher = request.getRequestDispatcher("timer.jsp");
                dispatcher.forward(request, response);
            }
        }

        Cookie[] cookies = request.getCookies();
        boolean isTime = false;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("seconds"))
                isTime = true;
        }
        if (isTime) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("timer-result.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("timer.jsp");
            dispatcher.forward(request, response);
        }
    }
}
