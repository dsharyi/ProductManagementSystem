<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Изменения товаров </title>
</head>
<body style="background:whitesmoke">
<div style="padding-top: 5%">
    <h2 align="center">Форма для изменения товара</h2>
    <table border="1" width="800" align="center" cellpadding="10">
        <form:form action="/product/update" method="post" modelAttribute="updateProduct">
            <input hidden name="id" value="${product.id}">
            <tr align="center">
                <th>Наименование</th>
                <td>${product.name}</td>
                <td><form:input path="name" required="required"/></td>
            </tr>
            <tr align="center">
                <th>Описание</th>
                <td>${product.description}</td>
                <td><form:input path="description" required="required"/></td>
            </tr>
            <tr align="center">
                <th>Производитель</th>
                <td>${product.manufacturer}</td>
                <td><form:input path="manufacturer" required="required"/></td>
            </tr>
            <tr align="center">
                <th>Цена</th>
                <td>${product.price}</td>
                <td><form:input type="number" path="price" required="required" min="1"
                                max="9999999999"/></td>
            </tr>
            <tr>
                <td colspan="5">
                    <div align="center"><form:button>Внести изменения</form:button></div>
                </td>
            </tr>

        </form:form>
    </table>


</div>
</body>
</html>