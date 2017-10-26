<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Список пользователей</title>
</head>
<body style="background:whitesmoke">
<div  style="padding-top: 5%">
    <h2 align="center">Список пользователей в системе</h2>
    <table border="1" width="800" align="center" cellpadding="10">
        <tr align = "center">
            <th>Email</th>
            <th>Тип пользователя</th>
            <th>Удаление пользователей</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr align = "center">
                <td>${user.email}</td>
                <td>${user.admin ? "Админ" : "Пользователь"}</td>
                <td><form action="${pageContext.request.contextPath}/user/delete${user.id}" method="get"><input type="submit" value="Удалить"/></form></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div align="center">
<form action="../main" method="post"><input type="submit" style="margin-top: 25px" value="Назад на главную" align="center"></form>
</div>
</body>
</html>