<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<div class="main">
<form action="/search" method="post">
    <h1>Search:</h1>
    <table border="2">
        <tr style="font-weight: bold">
            <td><input type="text" name="search" placeholder="Enter client name"></td>
            <td><input type="submit" name="searchBt" value="search"></td>
        </tr>
    </table>
</form>
<c:if test="${foundUser.size() == 0}">
    <h1>Client didn't find</h1>
</c:if>
<c:if test="${foundUser.size() != 0}">
    <table border="1">

        <tr class="table_header" >
            <td>ID</td>
            <td>User Name</td>
            <td>Pet type</td>
            <td>Pet name</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${foundUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.pet.getClass().getSimpleName()}</td>
                <td>${user.pet.getName()}</td>
                <td><a href="delete?id=${user.id}">To delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<a class="moveTo" href="view">Back to main page</a>
</div>
</body>
</html>
