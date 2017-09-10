<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 04.09.2017
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choice</title>
</head>
<body>
<form action="CheckBox" method="post">
    Ви можете оформити такі послуги:<br>
    <input type="checkbox" name="gym" value="50"> 1 заняття - 50 грн<br>
    <input type="checkbox" name="gym" value="700"> 16 занять - 700 грн<br>
    <input type="checkbox" name="gym" value="800"> абонемент на місяць - 800 грн<br>
    <input type="checkbox" name="gym" value="600"> абонемент на місяць для студентів (до 6 год) - 600 грн<br>
    <input type="checkbox" name="gym" value="100"> консультацї тренера - 100 грн<br>
    <input type="checkbox" name="gym" value="250"> програма занять від тренера - 250 грн<br>
    <input type="checkbox" name="gym" value="150"> сауна (1 похід) - 150 грн<br>
    <input type="checkbox" name="gym" value="1800"> безліміт на все - 1800 грн<br><br>
    <input type = "submit" value = "buy">
</form>
</body>
</html>
