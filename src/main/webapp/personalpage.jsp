<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 21.08.2017
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Page</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    ServletContext context = config.getServletContext();
    writer.print("host : "+context.getInitParameter("host"));
%>
 <form action="FirstServlet" method="post">
     Login: <input type="text" name = "login"><br>
     Password <input type="password" name = "password"><br>
     <input type = "submit" value = "Sign in">
 </form>
</body>
</html>
