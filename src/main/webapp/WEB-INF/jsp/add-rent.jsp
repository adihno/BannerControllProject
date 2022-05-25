<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%--@elvariable id="rent" type="pl.coderslab.entity.Rents"--%>
<%--@elvariable id="renter" type="pl.coderslab.entity.Renters"--%>
<form:form modelAttribute="rent" method="post">
    <label for="price">Price</label>
    <form:input path="price"/>
    <form:errors path="price" cssClass="error" />
    <br/>

    <label for="rented_from">Rented from:</label>
    <form:input path="rented_from" />
    <form:errors path="rented_from" cssClass="error" />
    <br/>

    <label for="rented_until">Rented until:</label>
    <form:input path="rented_until" />
    <form:errors path="rented_until" cssClass="error" />
    <br/>
    <label for="renter.id">Choose renter</label>
    <form:select path="renter.id" items="${renters}" itemValue="id" itemLabel="firstName" cssClass="error">
<%--        <c:forEach var ="renter" items="${renters}">--%>
<%--        <form:option value="${renter.id}"/>--%>
<%--        </c:forEach>--%>
        <form:errors path="renter.id" cssClass="error"/>
    </form:select>


    <br/>
    <input type="submit">
</form:form>

</body>
</html>
