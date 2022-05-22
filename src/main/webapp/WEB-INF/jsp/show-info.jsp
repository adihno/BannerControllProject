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
</head>
<body>
<%--@elvariable id="banner" type="java.util.List<pl.coderslab.entity.Banners>"--%>
<%--@elvariable id="rent" type="java.util.List<pl.coderslab.entity.Rents>"--%>

<table>
    <tr>
        <th>Street</th>
        <th>Price</th>
        <th>is Rented</th>
        <th>rented from</th>
        <th>rented until</th>
    </tr>
    <c:forEach var ="banners" items="${banner}">
    <tr>
        <td>${banners.street}</td>
        <td>${banners.price}</td>
        <td>${banners.is_rented}</td>
        <c:choose>
        <c:when test="${!banners.is_rented}">
            <td>Banner is not rented yet</td>
        </c:when>
        <c:otherwise>
            <td>${banners.rents.rented_from}</td>
            <td>${banners.rents.rented_until}</td>

        </c:otherwise>
        </c:choose>

    </tr>
    <td><input type="submit" value="Wstecz"></td>
    </c:forEach>
</table>



</body>
</html>
