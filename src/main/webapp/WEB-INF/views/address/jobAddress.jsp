<%@ taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Работа с адресами</title>
</head>
<body>
<table cellspacing="2" border="1" cellpadding="5" width="600">
    <thead>
    <tr>
        <th>id</th>
        <th>country</th>
        <th>city</th>
        <th>street</th>
        <th>postCode</th>

        <form:forEach items="${listAddress}" var="address">
    <tr>
        <td>${address.id}</td>
        <td>${address.country}</td>
        <td>${address.city}</td>
        <td>${address.street}</td>
        <td>${address.postCode}</td>
        <td><a href="<c:url value="/address/getByIdAddress/${address.id}" />">Query</a> </td>
        <td><a href="<c:url value="/address/updateAddress/${address.id}"/>">Редактирование</a> </td>
        <td><a class="deleteButton" href="<form:url value="/address/delete/${address.id}"/>">Delete</a> </td>
    </tr>
        </form:forEach>
    </tr>
    </thead>
</table>
<div>
    <a href="/address/newAddress">
        <button>Новая запись</button>
    </a>
    <div>
        <a href="<c:url value="/menu" /> ">
            <button>Назад в меню</button>
        </a>
    </div>
</div>
</body>
</html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/address/deleteAddressForm.js"></script>
<%--<script type="text/javascript">--%>
    <%--$('.deleteButton').click(function () {--%>
        <%--var url = $(this).attr("href");--%>
        <%--$.ajax({--%>
            <%--type: "GET",--%>
            <%--url: url,--%>
            <%--success: function (data) {--%>
                <%--window.location = data;--%>
                <%--// alert(data); // show response from the php script.--%>
            <%--}--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>