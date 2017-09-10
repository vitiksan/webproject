package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created by on 09.09.2017.
@WebServlet(name = "TimerResult")
public class TimerResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int hours = Integer.parseInt(request.getParameter("hours"));
        int minutes = Integer.parseInt(request.getParameter("minutes"));
        int seconds = Integer.parseInt(request.getParameter("seconds"));
        ServletContext context = getServletContext();
        MyTimerTask task = new MyTimerTask(hours, minutes, seconds);
        context.setAttribute("task", task);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        RequestDispatcher dispatcher = request.getRequestDispatcher("timerresult.jsp");
        dispatcher.forward(request, response);
    }
}
