<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 09.09.2017
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Timer</title>
</head>
<body>
<form action="TimerResult" method="post">
    <label>Hours :<input type="number" name="hours"></label><br>
    <label>Minutes :<input type="number" name="minutes"></label><br>
    <label>Seconds :<input type="number" name="seconds"></label><br><br>
    <input type="submit" name="start" value="Start">
</form>
</body>
</html>
