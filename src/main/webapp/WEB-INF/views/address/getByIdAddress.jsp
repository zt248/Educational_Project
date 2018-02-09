<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address Detail</title>
</head>
<body>
<h1>User Detail</h1>
<br />

<table border="1">
    <tr>
        <td>Id</td>
        <td>${address.id}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${address.country}</td>
    </tr>
    <tr>
        <td>City</td>
        <td>${address.city}</td>
    </tr>
    <tr>
        <td>Street</td>
        <td>${address.street}</td>
    </tr>
    <tr>
        <td>PostCode</td>
        <td>${address.postCode}</td>
    </tr>
</table>

</body>
</html>
