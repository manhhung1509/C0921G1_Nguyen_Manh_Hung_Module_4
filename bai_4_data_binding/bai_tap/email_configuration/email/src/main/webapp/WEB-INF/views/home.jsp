<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<form:form action="update" method="post" modelAttribute="mail">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td>Language</td>
                <td>
                    <form:select path="language">
                        <form:option value="none" label="------- Select One -------" />
                        <form:options items="${languageList}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page Size</td>
                <td>
                    <form:select path="pageSize">
                        <form:option value="-1" label="------- Select One -------" />
                        <form:options items="${pageSizeList}" />
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    Enable spam filter
                </td>
                <td>
                    <form:checkbox path="spamFilter"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="signature">signature:</form:label></td>
                <td><form:textarea cols="30" rows="5" path="signature"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
