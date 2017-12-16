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
    <h3>Search</h3>
            <div >
            <input type="text" name="search" placeholder="Enter client name" class="inputForm">
            <input type="submit" name="searchBt" value="Search" class="submit">
            </div>
</form>
<c:if test="${foundUser.size() == 0}">
    <h1>Client didn't find</h1>
</c:if>
<c:if test="${foundUser.size() >= 1}">
    <table>
        <caption>Searched users</caption>
        <tr>
            <th>ID</th>
            <th>User Name</th>
            <th>Pet type</th>
            <th>Pet name</th>
            <th>Action</th>
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
    <div class="moveTo" >
        <a href="/view">Back to the main page</a>
    </div>

</div>
</body>
</html>
