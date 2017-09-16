<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    Cookie[] cookies = request.getCookies();
    String login = "";
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("login")) {
            login = cookies[i].getValue();
        }
    }
    writer.print("<h2 align=\"center\">Hello " + login + "</h2><br>");
%>
<div align="center">
<form action="Servlet1" method="post">
    <label>Choice date: <input type="date" name="calendar" value="1997-11-29"></label>
    <input type="submit" value="Show">
    </form>
</div>
</body>
</html>
