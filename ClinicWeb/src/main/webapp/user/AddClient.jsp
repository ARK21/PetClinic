<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add client</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<div class="main">
<h1>Add client panel</h1>

<form action="${pageContext.servletContext.contextPath}/add" method="post">
    <table>
        <tr class="table_header">
            <td>
                Name
            </td>
            <td>
                Pet type
            </td>
            <td>Pet name</td>
        </tr>
        <tr>
            <td>
                <input type="text" name="clientName" placeholder="Enter your name">
            </td>
            <td>
                <select name="petType">
                    <option value="1">Cat</option>
                    <option value="2">Dog</option>
                    <option value="3">Parrot</option>
                </select>
            </td>
            <td>
                <input type="text" name="petName" placeholder="Enter pet name">
            </td>
        </tr>
    </table>
    <input class="button" type="submit" name="Add" value="AddClient">
</form>
</div>
</body>
</html>
