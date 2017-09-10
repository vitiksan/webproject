<%@ page import="com.test.servlets.Login" %>

<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>Welcome to company</h1>
<%
    Login user = (Login) request.getAttribute("bean");
%>
</body>
</html>
