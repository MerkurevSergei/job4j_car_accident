<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Номер:</td>
            <td><label>
                <input type='text' name='id'>
            </label></td>
        </tr>
        <tr>
            <td>Название:</td>
            <td><label>
                <input type='text' name='name'>
            </label></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><label>
                <input type='text' name='text'>
            </label></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><label>
                <input type='text' name='address'>
            </label></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
        </tr>
    </table>
</form>
</body>
</html>