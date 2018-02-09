<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Места работы</title>
</head>
<body>
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>Id</th>
        <th>position</th>
        <th width="100"></th>
        <th width="100"></th>
        <th width="100"></th>
    </tr>
    </thead>
    <tbody>
    <form:forEach items="${listDepartment}" var="department">
        <tr>
            <th>${department.id}</th>
            <th>${department.position}</th>
            <th><a href="<form:url value="/department/getByIdDepartment/${department.id}"/> ">
                <button>Query</button>
            </a></th>
            <th><a href="<form:url value="/department/getUpdateDepartmentForm/${department.id}"/> ">
                <button>Редактировать</button>
            </a></th>
            <th><a href="<form:url value="/department/deleteDepartment/${department.id}"/> ">
                <button>Удалить</button>
            </a></th>
        </tr>
    </form:forEach>
    </tbody>
</table>
<div>
    <a href="/department/getAddDepartmentForm">
        <button>Новая запись</button>
    </a>
    <div>
        <a href="<form:url value="/menu" /> ">
            <button>Назад в меню</button>
        </a>
    </div>
</div>
</body>
</html>

