<%--
  Created by IntelliJ IDEA.
  User: atrik
  Date: 18.10.2017
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <p>choose file: </p> <input type="file" name="file-name"><br/>
    <input type="submit" value="upload">
</form>
</body>
</html>
