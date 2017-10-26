<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Стартовая страница</title>
</head>
<body  style="background:whitesmoke">

<div align="center" style="padding-top: 12%">
    <h1>Добро пожаловать в наш магазин</h1>
</div>

<div align="center">
    <form action="/main" method="get">
        <input type="submit" value="Войти">
    </form>
</div>
<div align="center">
    <form action="/registration" method="get">
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>

</body>
</html>