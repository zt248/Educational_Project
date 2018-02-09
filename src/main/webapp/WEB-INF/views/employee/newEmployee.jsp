<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form:form action="/employees/addEmployees" method="post" modelAttribute="employee">
        <table>
            <tr>
                <td>Имя</td>
                <td>Фамилия</td>
                <td>Дата рождения</td>
                <td>Страна</td>
                <td>Город</td>
                <td>Улица</td>
                <td>Почтовый индекс</td>
                <td>Должность</td>
            </tr>
            <tr>
                <td><form:input path="firstName"/></td>
                <td><form:input path="lastName"/></td>
                <td><form:input path="birthday"/></td>
                <td><form:input path="country"/></td>
                <td><form:input path="city"/></td>
                <td><form:input path="street"/></td>
                <td><form:input path="postCode"/></td>

                <td><form:select path="departments" items="${department}" itemLabel="position" itemValue="id" multiple="true"/></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
