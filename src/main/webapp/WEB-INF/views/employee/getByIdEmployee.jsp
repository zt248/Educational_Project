<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" id="example" class="display">
    <thead>
    <th>id</th>
    <th>Имя</th>
    <th>Фамилия</th>
    <th>День рождения</th>
    <th>Страна</th>
    <th>Город</th>
    <th>Улица</th>
    <th>Почтовый индекс</th>
    <th>Отдел</th>
    <tr>
        <td>${employee.id}</td>
        <td>${employee.firstName}</td>
        <td>${employee.lastName}</td>
        <td>${employee.birthday}</td>
        <td>${employee.address.country}</td>
        <td>${employee.address.city}</td>
        <td>${employee.address.street}</td>
        <td>${employee.address.postCode}</td>
        <td>
            <c:forEach items="${employee.departments}" var="department">
                ${department.position}<br/>
            </c:forEach>
        </td>
    </tr>
</table>
<div>
    <a href="<c:url value="/menu" /> ">
        <button>Назад в меню</button>
    </a>
</div>
</body>
</html>
