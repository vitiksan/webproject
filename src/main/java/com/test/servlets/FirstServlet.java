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
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServletContext context = getServletContext();


        Login signin = new Login();
        signin.setLogin(login);
        signin.setPassword(password);

        request.setAttribute("bean",signin);

        ServletConfig config = getServletConfig();
        String admLogin = config.getInitParameter("login");
        String pass = config.getInitParameter("pass");


        if (admLogin.equals(signin.getLogin()) && pass.equals(signin.getPassword())){
            RequestDispatcher requestDispatcher  = request.getRequestDispatcher("login-success.jsp");
            requestDispatcher.forward(request,response);
        }else{
            writer.print("<h1>Wrong login or password</h1>");
            RequestDispatcher requestDispatcher  = request.getRequestDispatcher("personalpage.jsp");
            requestDispatcher.include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("personalpage.jsp");
        requestDispatcher.forward(request,response);
        doPost(request,response);
    }
}
