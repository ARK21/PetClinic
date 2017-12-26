<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add client</title>
    <link rel="stylesheet" href="/css/stylesheet.css">
</head>
<body>
<div class="main">


    <form action="${pageContext.servletContext.contextPath}/add" method="post">
        <h3>Add client panel</h3>
        <div class="clientNameForm">
            <label>Client name:
                <input type="text" name="clientName" placeholder="Enter your name" class="inputForm">
            </label>
        </div>
        <div class="petNameForm">
            <label>Type:
                <select name="petType">
                    <option value="Cat">Cat</option>
                    <option value="Dog">Dog</option>
                    <option value="Parrot">Parrot</option>
                </select>
            </label>
            <label>Pet name:
                <input type="text" name="petName" placeholder="Enter pet name" class="inputForm">
            </label>
        </div>


        <input class="submit" type="submit" name="Add" value="Add client">

    </form>
    <div class="moveTo" >
        <a href="/view">Back to the main page</a>
    </div>
</div>
</body>
</html>
