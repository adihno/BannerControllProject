<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
<h1>Dashboard</h1>
<br>

<h2> <a href="/dashboard/add">Dodaj nowy baner</a> </h2>
<table>
    <tr>
        <th>Banners</th>
        <th>Localization</th>
    </tr>
    <%--@elvariable id="banners" type="java.util.List<pl.coderslab.entity.Banners>"--%>
    <c:forEach var="banner" items="${banners}">

        <tr>
            <td>Banner</td>
            <td>${banner.street}</td>
            <td><a href="/dashboard/info/${banner.id}" >Wiecej informacji</a> </td>
            <td> <a href="/dashboard/edit/${banner.id}" >Edytuj </a></td>
            <td> <a href="/dashboard/delete/${banner.id}" >Usun </a></td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
