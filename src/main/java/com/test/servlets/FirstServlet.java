package com.test.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Login signin = new Login();
        signin.setLogin(login);
        signin.setPassword(password);

        request.setAttribute("bean",signin);

        ServletConfig config = getServletConfig();
        String admLogin = config.getInitParameter("login");
        String pass = config.getInitParameter("pass");

        Cookie cookie = new Cookie("login",login);
        cookie.setMaxAge(120);
        response.addCookie(cookie);

        HttpSession session = request.getSession();
        session.setAttribute("loginObject",signin);

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
