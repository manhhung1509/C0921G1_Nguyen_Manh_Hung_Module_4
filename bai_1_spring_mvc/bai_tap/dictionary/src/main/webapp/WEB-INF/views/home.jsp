<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h2>Dictionary</h2>
<form action="/translate" method="post">
    <label>Word : </label><br/>
    <input type="text" name="word" placeholder="enter word" value="${word}" /><br/>
     <h3>Mean : ${mean}</h3>
    <input type = "submit" id = "submit" value = "enter"/>
</form>
</body>
</html>
