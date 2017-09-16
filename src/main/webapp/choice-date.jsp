<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 16.09.2017
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your choice</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    Cookie[] cookies = request.getCookies();
    String login = "";
    String date = "";
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("login")) {
            login = cookies[i].getValue();
        } else if (cookies[i].getName().equals("date")) {
            date = cookies[i].getValue();
        }
    }


    writer.print("<h2>Your name: " + login + "</h2>" +
            "<h2>You select date: " + date + "</h2>");
%>
</body>
</html>
