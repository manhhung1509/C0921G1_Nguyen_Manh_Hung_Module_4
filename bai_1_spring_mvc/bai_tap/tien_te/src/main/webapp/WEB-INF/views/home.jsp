<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h2>Currency Converter</h2>
<form action="/convert" method="post" >
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000" readonly/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="${usd}"/><br/>
     <h3>VND = ${vnd}</h3>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
