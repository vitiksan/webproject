<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Enumeration" %>
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
    PrintWriter writer = response.getWriter();
    Cookie[] cookies = request.getCookies();
    Integer hours = 0;
    Integer minutes = 0;
    Integer seconds = 0;
    boolean end = false;
    Enumeration<String> names = request.getParameterNames();
    while (names.hasMoreElements()) {
        if (names.nextElement().equals("back"))
            end = true;
    }
    for (int i = 0; i < cookies.length; i++) {
        if (cookies[i].getName().equals("hours")) {
            hours = Integer.parseInt(cookies[i].getValue());
        } else if (cookies[i].getName().equals("minutes")) {
            minutes = Integer.parseInt(cookies[i].getValue());
        } else if (cookies[i].getName().equals("seconds")) {
            seconds = Integer.parseInt(cookies[i].getValue());
        }
    }

    if (hours != 0 || minutes != 0 || seconds != 0) {
        writer.print("<h1 align=\"center\">" + hours + ":" + minutes + ":" + seconds + "</h1>");
    } else {
        writer.print("<h1 align=\"center\">The end!</h1>");
        end = true;

    }

    if (seconds > 0) seconds--;
    else if (minutes > 0) {
        minutes--;
        seconds = 59;
    } else if (hours > 0) {
        hours--;
        minutes = 59;
        seconds = 59;
    }
    Cookie cookieHours = new Cookie("hours", hours.toString());
    cookieHours.setHttpOnly(true);
    Cookie cookieMinutes = new Cookie("minutes", minutes.toString());
    cookieMinutes.setHttpOnly(true);
    Cookie cookieSeconds = new Cookie("seconds", seconds.toString());
    cookieSeconds.setHttpOnly(true);
    if (end) {
        cookieHours.setMaxAge(0);
        cookieMinutes.setMaxAge(0);
        cookieSeconds.setMaxAge(0);
    }
    response.addCookie(cookieHours);
    response.addCookie(cookieMinutes);
    response.addCookie(cookieSeconds);

    response.setIntHeader("Refresh", 1);
%>
<div align="center">
    <form action="Timer" method="get">
        <input type="submit" name="back" value="Back">
    </form>
</div>
</body>
</html>
