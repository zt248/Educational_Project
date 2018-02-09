<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees List</title>
</head>
<thead>

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
    <c:forEach items="${listEmployees}" var="employees">
    <tr>
        <td>${employees.id}</td>
        <td>${employees.firstName}</td>
        <td>${employees.lastName}</td>
        <td>${employees.birthday}</td>
        <td>${employees.address.country}</td>
        <td>${employees.address.city}</td>
        <td>${employees.address.street}</td>
        <td>${employees.address.postCode}</td>
        <td>
            <c:forEach items="${employees.departments}" var="department">
                ${department.position}<br/>
            </c:forEach>
        </td>
        <td>Query</td>
        <td><a href="<c:url value="/employees/update/${employees.id}"/> "><button>Редакрировать</button></a> </td>
        <td><a class="deleteButton" href="<c:url value="/employees/delete/${employees.id}" /> ">
            <button>Удалить</button>
        </a></td>
    </tr>
    </c:forEach>

</table>

<a href="<c:url value="/employees/newEmployees" /> ">
    <button>Новая запись</button>
</a>
</thead>

</body>
</html>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">

</script>
<script type="text/javascript">

    $('.deleteButton').click(function () {
        var url = $(this).attr("href");
        $.ajax({
            type: "GET",
            url: url,
            success: function (data) {
                window.location = data;
                // alert(data); // show response from the php script.
            }
        })
    })

</script>