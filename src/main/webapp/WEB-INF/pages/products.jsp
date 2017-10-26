<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Список товаров</title>
</head>
<body style="background:whitesmoke">
<div style="padding-top: 5%">
    <h2 align="center">Список товаров</h2>
    <table border="1" width="800" align="center" cellpadding="10">
        <tr align="center">
            <th>Название</th>
            <th>Описание</th>
            <th>Производитель</th>
            <th>Цена</th>
            <sec:authorize access="hasRole('ADMIN')">
                <th>Удалить</th>
                <th>Изменить</th>
            </sec:authorize>
        </tr>
        <c:forEach items="${productList}" var="product">
            <tr align="center">
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.manufacturer}</td>
                <td>${product.price}</td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td>
                        <form action="/product/delete${product.id}" method="get"><input type="submit" value="Удалить">
                        </form>
                    </td>
                    <td>
                        <form action="/product/update_product${product.id}" method="get"><input type="submit"
                                                                                                value="Изменить"></form>
                    </td>
                </sec:authorize>
            </tr>
        </c:forEach>
    </table>
</div >
<sec:authorize access="hasRole('ADMIN')">
    <div align="center">
        <form action="${pageContext.request.contextPath}/product/validate" method="get">
            <input type="submit" style="margin-top: 25px" value="Добавить новый продукт" align="center"/>
        </form>
    </div>
</sec:authorize>
<div align="center">
    <form action="${pageContext.request.contextPath}/main" method="post">
        <input type="submit" style="margin-top: 25px" value="Назад на главную" align="center">
    </form>
</div>
</body>
</html>