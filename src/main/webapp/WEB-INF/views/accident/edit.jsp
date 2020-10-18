<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Номер:</td>
            <td><label>
                <input type='text' name='id' value='${accident.id}'>
            </label></td>
        </tr>
        <tr>
            <td>Название:</td>
            <td><label>
                <input type='text' name='name' value='${accident.name}'>
            </label></td>
        </tr>
        <tr>
            <td>Описание:</td>
            <td><label>
                <input type='text' name='text' value='${accident.text}'>
            </label></td>
        </tr>
        <tr>
            <td>Адрес:</td>
            <td><label>
                <input type='text' name='address' value='${accident.address}'>
            </label></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
        </tr>
    </table>
</form>
</body>
</html>