<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 20.09.2017
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    writer.print("<p>" + request.getAttribute("message") + "</p>");
%>
</body>
</html>
