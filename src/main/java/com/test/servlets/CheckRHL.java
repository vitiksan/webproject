package com.test.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Enumeration;

// Created by on 04.09.2017.
@WebServlet(name = "CheckRHL")
public class CheckRHL extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        //response.sendError(407,"Go away bastard");
        response.setContentType("text/html");
        response.setIntHeader("Refresh",15);

        String style = getServletConfig().getInitParameter("style");

        String dateStamp = LocalDateTime.now().toString();
        String title = "Request headers list";
        writer.print(
                "<html>" +
                        "<head>" +
                        "<title>" + title + "</title>" +
                        "</head>" +
                        "<body>" +
                        "<table "+style+">" +
                        "<tr>" +
                        "<td>"+dateStamp+"</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<th>Header</th>" +
                        "<th>Value</th>" +
                        "</tr>"
        );

        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            String headerValue = request.getHeader(headerName);

            writer.print(
                    "<tr>" +
                            "<td>" + headerName + "</td>" +
                            "<td>" + headerValue + "</td>" +
                            "</tr>");
        }
        writer.print(
                "</table>" +
                        "</body>" +
                        "</html>"
        );
    }
}
