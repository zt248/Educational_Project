<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>

<form:form method="post" id="updateAddressForm">
    <%--<form:form method="post" action="/address/getUpdateAddress" >--%>
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="Country">Страна</form:label></td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td><form:label path="City">Город</form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="Street">Улица</form:label></td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td><form:label path="PostCode">Почтовый индекс</form:label></td>
            <td><form:input path="postCode"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Редактировать"/>
            </td>
        </tr>
    </table>

</form:form></body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/address/updateAddressForm.js"></script>
<%--<script type="text/javascript">--%>
    <%--$('#updateAddressForm').submit(function (e) {--%>
    <%--var url = "<c:url value="/address/getUpdateAddressAjax"/>"--%>
    <%--$.ajax({--%>
    <%--type: "POST",--%>
    <%--url: url,--%>
    <%--data: $("#updateAddressForm").serialize(),--%>
    <%--success: function (data) {--%>
    <%--window.location = data;--%>
    <%--// alert(data); // show response from the php script.--%>
    <%--}--%>
    <%--})--%>
    <%--e.preventDefault();--%>
    <%--})--%>
<%--</script>--%>

