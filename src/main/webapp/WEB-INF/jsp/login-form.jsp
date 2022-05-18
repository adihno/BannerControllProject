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
<%--@elvariable id="admin" type="pl.coderslab.entity.Admin"--%>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${param.error != null}">

        <div>
            Invalid username and password.
        </div>

    </c:if>
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password" >
    <input type="submit">
</form:form>




</body>
</html>
