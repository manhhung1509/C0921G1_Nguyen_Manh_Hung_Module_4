<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validate</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="/save" method="post">
    <input type="checkbox" id="condiment1" name="condiment" value="Lettuce">
    <label for="condiment1"> Lettuce</label><br>
    <input type="checkbox" id="condiment2" name="condiment" value="Tomato">
    <label for="condiment2"> Tomato</label><br>
    <input type="checkbox" id="condiment3" name="condiment" value="Mustard">
    <label for="condiment3"> Mustard</label><br><br>
    <input type="checkbox" id="condiment4" name="condiment" value="Sprouts">
    <label for="condiment4"> Sprouts</label><br><br>
    <input type="submit" value="Save">

    <h4 style="color: red">${element}</h4>
    <c:forEach var="condiment" items="${condiment}">
        <h4>${condiment}</h4>
    </c:forEach>
</form>
</body>
</html>
