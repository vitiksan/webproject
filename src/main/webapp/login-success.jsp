<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.test.servlets.Login" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    PrintWriter writer = response.getWriter();
    Cookie[] cookies = request.getCookies();
    HttpSession newSession = request.getSession(false);
    String login = "";
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("login")) {
            login = cookies[i].getValue();
        }
    }
    Login signIn = (Login) newSession.getAttribute("loginObject");
    writer.print("<h2 align=\"center\">Hello " + signIn.getLogin() + "</h2><br>");
    writer.print("<h2 align=\"center\">Your password: " + signIn.getPassword() + "</h2><br>");
%>
<div align="center">
<form action="Servlet1" method="post">
    <label>Choice date: <input type="date" name="calendar" value="1997-11-29"></label>
    <input type="submit" value="Show">
    </form>
</div>
</body>
</html>
