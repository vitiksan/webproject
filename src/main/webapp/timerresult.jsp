<%@ page import="com.test.servlets.MyTimerTask" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 09.09.2017
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    response.setIntHeader("Refresh", 1);
    PrintWriter writer = response.getWriter();
    ServletContext context = config.getServletContext();
    MyTimerTask task = (MyTimerTask) context.getAttribute("task");

    writer.print("<h1 align=\"center\">" + task.run() + "</h1>");

    context.removeAttribute("task");
    context.setAttribute("task", task);
%>
<form action="Timer" method="get">
    <input type="submit" name="back" value="Back">
</form>
</body>
</html>
