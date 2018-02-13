<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css" type="text/css"/>
</head>
<body>
<div class="main">

    <c:if test="${users.size() == 0}">
        <h1>Clinic is empty</h1>
    </c:if>
    <c:if test="${users.size() != 0}">
        <table>
            <caption>Paws & Tails</caption>
            <tr>
                <th>Id</th>
                <th>User Name</th>
                <th>Pet type</th>
                <th>Pet name</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.pet.getClass().getSimpleName()}</td>
                    <td>${user.pet.getName()}</td>
                    <td>
                        <div><a href="delete?id=${user.id}">To delete</a></div>
                        <div><a href="edit?id=${user.id}">To edit</a></div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <div class="moveContainer">
        <div class="mc1">
            <a href=${pageContext.servletContext.contextPath}/user/AddClient.jsp>Add client</a>
        </div>
        <div class="mc2">
            <a href=${pageContext.servletContext.contextPath}/user/Search.jsp>Search client</a>
        </div>
    </div>
</div>
</body>
</html>
