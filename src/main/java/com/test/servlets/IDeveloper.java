package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created by on 04.09.2017.
@WebServlet(name = "IDeveloper")
public class IDeveloper extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language= request.getParameter("language");
        String number= request.getParameter("number");
        String dataType= request.getParameter("dataType");
        request.setAttribute("language",language);
        request.setAttribute("number",number);
        request.setAttribute("dataType",dataType);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("developer.jsp");
        requestDispatcher.forward(request,response);
    }
}
