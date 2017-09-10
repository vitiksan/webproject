<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 04.09.2017
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Developer</title>
</head>
<body>
<h1>I coding in
 <%

     request.getParameter("language");
 %>${language} ${number} ${dataType}</h1>
</body>
</html>