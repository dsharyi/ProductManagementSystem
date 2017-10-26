<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Добавление товара</title>
</head>
<body style="background:whitesmoke">
<div align="center" style="padding-top: 8%">
    <h3>Новый товар:</h3>
    <form:form modelAttribute="productFromPage" method="post" action="/product/save">
        <p><label>Название:<br>
            <form:input path="name" size="30" maxlength="30" required = "required" placeholder = "Введите название продукта"/></label></p>
        <p><label>Описание:<br>
            <form:input path="description" size="30" maxlength="255" required = "required" placeholder = "Введите описание продукта" /></label></p>
        <p><label>Производитель:<br>
            <form:input path="manufacturer" size="30" maxlength="30" required = "required" placeholder = "Введите название производителя"/></label></p>
        <p><label>Цена:<br>
            <form:input type = "number" path="price" size="30" maxlength="30" required = "required" min="1" max="9999999999" placeholder = "Введите цену"/></label></p>
    <div align="center">
        <p><form:button>Добавить товар</form:button></p>
    </form:form>
    </div>
</div>
</body>
</html>