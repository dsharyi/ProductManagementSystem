<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Добро пожаловать!</title>
</head>
<body  style="background:whitesmoke">
<div align="center" style="padding-top: 12%">
    <h2>Добро пожаловать, <sec:authentication property="principal.username"/></h2>
    <h2>Для Вас доступны следующие возможности: </h2>
    <form:form action="/product/list" method="get">
        <input type="submit" value="Список товаров">
    </form:form>
    <sec:authorize access="hasRole('ADMIN')">
        <form:form action="/user/list" method="get">
            <input type="submit" value="Список пользователей">
        </form:form>
    </sec:authorize>
    <form:form action="/logout" method="post">
        <input type="submit" value="Выйти с данного аккаунта">
    </form:form>
</div>
</body>
</html>