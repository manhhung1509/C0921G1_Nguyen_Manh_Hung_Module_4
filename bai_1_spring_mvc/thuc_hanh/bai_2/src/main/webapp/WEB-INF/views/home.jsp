<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<form action="/searchCustomer" method="get">
    <input type="text" name="id" placeholder="Nhập customer Id">
    <button  type="submit" name="action" value="search">Search</button>
</form>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Update</th>
    </tr>
    <c:forEach items="${requestScope['customerList']}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
            <td><a href="/ShowUpdateCustomer?cId=${customer.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
