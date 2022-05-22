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

<%--@elvariable id="banners" type="pl.coderslab.entity.Banners"--%>
<form:form modelAttribute="banners" method="post">
    <label for="street">Street</label>
    <form:input path="street"/>
    <form:errors path="street" cssClass="error" />
    <br/>

    <label for="price">Price</label>
    <form:input path="price" />
    <form:errors path="price" cssClass="error" />
    <br/>

    <label for="is_rented">Is rented?</label>
    <form:select path="is_rented" cssClass="error">
    <form:option value="true"/>
    <form:option value="false"/>
        <form:errors path="is_rented" cssClass="error"/>
    </form:select>

    <br/>
    <input type="submit">
</form:form>

</body>
</html>
