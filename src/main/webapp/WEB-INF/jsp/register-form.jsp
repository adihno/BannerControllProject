<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02.05.2022
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="admin" type="pl.coderslab.entity.Admin"--%>

<form:form modelAttribute="admin" method="post">
    Email <form:input path="email"/>
    Password <form:password path="password"/>
    <input type="submit">
</form:form>




</body>
</html>
