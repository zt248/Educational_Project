<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NewEmployees</title>

</head>
<body>


<form:form method="post" id="addressForm" action="/address/addSt-ajax">
<%--<form:form method="post" id="addressForm" action="/address/addAddress">--%>
    <table>
        <tr>
            <td><form:label path="Country">Country</form:label></td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td><form:label path="City">City</form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="Street">Street</form:label></td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td><form:label path="PostCode">PostCode</form:label></td>
            <td><form:input path="postCode"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>

</form:form>

<div>
    <a href="<c:url value="/menu" /> ">
        <button>Назад в меню</button>
    </a>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/address/addAddressForm.js"></script>

<%--<script type="text/javascript">--%>
    <%--$('#addressForm').submit(function (e) {--%>
    <%--var url = "<c:url value="/address/addAddressAjax"/>"--%>
    <%--$.ajax({--%>
    <%--type: "POST",--%>
    <%--url: url,--%>
    <%--data: $("#addressForm").serialize(),--%>
    <%--success: function (data) {--%>
    <%--window.location = data;--%>
    <%--// alert(data); // show response from the php script.--%>
    <%--}--%>

    <%--})--%>
    <%--e.preventDefault();--%>
    <%--})--%>

<%--</script>--%>


</body>
</html>
