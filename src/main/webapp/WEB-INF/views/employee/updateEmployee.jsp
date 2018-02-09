<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employees</title>
</head>
<body>
<form:form method="post" action="/employees/employeesUpdate" modelAttribute="employee">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td><form:label path="FirstName">Имя</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="LastName">Фамилия</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="country">Страна</form:label></td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td><form:label path="city">Город</form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="street">Улица</form:label></td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td><form:label path="postCode">Почтовый индекс</form:label></td>
            <td><form:input path="postCode"/></td>
        </tr>
        <tr>
            <td><form:label path="departments">Отдел</form:label></td>
            <td><form:select path="departments" items="${departments}" itemLabel="position" itemValue="id" size="20"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Редактировать"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>





