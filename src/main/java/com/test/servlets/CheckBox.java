package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created by on 04.09.2017.
@WebServlet(name = "CheckBox")
public class CheckBox extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] price = request.getParameterValues("gym");
        double allPrice = 0;
        for (String item : price)
            allPrice += Double.parseDouble(item);
        request.setAttribute("allPrice",allPrice);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("choice.jsp");
        requestDispatcher.forward(request, response);
    }
}
