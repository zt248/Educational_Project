<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form update department</title>
</head>
<body>
<form:form method="post"  action="/department/updateDepartment">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="Position">Должность</form:label></td>
            <td><form:input path="position"/></td>
        </tr>
    </table>
    <tr>
        <td colspan="2">
            <input type="submit" value="Редактировать">
        </td>
    </tr>
</form:form>

<a href="/department/getListDepartment"><button>Назад на гланую</button></a>
</body>
</html>
