<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<div class="main">
<h1 >Paws and tails clinic</h1>
<c:if test="${users.size() == 0}">
    <h1>Clinic is empty</h1>
</c:if>
<c:if test="${users.size() != 0}">
    <table>
        <tr class="table_header">
            <td>Id</td>
            <td>User Name</td>
            <td>Pet type</td>
            <td>Pet name</td>
            <td>Action</td>
        </tr>
        <c:forEach items="${users}" var="user">
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

<a class="moveTo" href=${pageContext.servletContext.contextPath}/user/AddClient.jsp>Add client</a>
<a class="moveTo" href=${pageContext.servletContext.contextPath}/user/Search.jsp >Search client</a>

</div>

</body>
</html>
