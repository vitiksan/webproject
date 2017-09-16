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
<div align="center">
    <form action="Timer" method="post">
        <label>Hours :<input type="number" name="hours" value="0"></label><br>
        <label>Minutes :<input type="number" name="minutes" value="0"></label><br>
        <label>Seconds :<input type="number" name="seconds" value="10"></label><br><br>
        <input type="submit" name="start" value="Start">
    </form>
</div>
</body>
</html>
