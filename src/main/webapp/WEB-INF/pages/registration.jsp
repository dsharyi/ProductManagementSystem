<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body style="background:whitesmoke">
<div align="center" style="padding-top: 12%">
    <h3 align="center">Форма регистрации</h3>
    <form method="post" action="/register">
        <table align="center">
            <tr align="center">
                <th align="left">Email</th>
                <td><input type="email" id="email" name="email" required="required" placeholder="Введите e-mail" size="30" maxlength="30"></td>
            </tr>
            <tr align="center">
                <th align="left">Пароль</th>
                <td><input type="password" id="password" name="password" required="required" placeholder="Введите пароль" size="30" maxlength="30"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="submit" width="30" value="Зарегистрировать"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

