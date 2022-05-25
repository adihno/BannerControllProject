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
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<%--@elvariable id="renter" type="pl.coderslab.entity.Renters"--%>
<form:form modelAttribute="renter" method="post">
    <label for="firstName">First name</label>
    <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error" />
    <br/>

    <label for="lastName">Last name</label>
    <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />
    <br/>

    <label for="phoneNumber">Phone number</label>
    <form:input path="phoneNumber" />
    <form:errors path="phoneNumber" cssClass="error" />
    <br/>

    <br/>
    <input type="submit">
</form:form>

</body>
</html>
