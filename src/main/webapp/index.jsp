<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 17.09.2017
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Welcome page</title>
</head>
<body link="#00008b" vlink="#00008b" alink="#dc143c">
<div align="center">
    <h2><a style="text-decoration: none; margin: 5px" href="/LoginServlet">Login</a>
        <a style="text-decoration: none; margin: 5px" href="/LogoutServlet">Logout</a>
        <a style="text-decoration: none; margin: 5px" href="/ProfileServlet">Profile</a>
    </h2>
</div>
<hr>
<h1 align="center">Welcome to our site</h1>
<div align="center">
    <jsp:include page="date-and-time.jsp" flush="true"/>
</div>
<div align="center">
    <jsp:include page="user-profile.jsp" flush="true"/>
</div>
</body>
</html>
