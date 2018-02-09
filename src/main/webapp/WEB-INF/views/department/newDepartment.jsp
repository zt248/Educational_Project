<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form of addition department</title>
</head>
<body>
<form:form method="post" id="addDepartment" action="/department/newDepartment">
    <table>
        <tr>
            <td><form:label path="Position">Должность</form:label></td>
            <td><form:input path="position"/></td>
        </tr>
    </table>
    <tr>
        <td colspan="2">
            <input type="submit" value="Добавить">
        </td>
    </tr>
</form:form>

<a href="/department/getListDepartment"><button>Назад на гланую</button></a>
</body>
</html>
