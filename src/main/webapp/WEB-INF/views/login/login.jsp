<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 05/09/2020
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
        </div>
        <input type="hidden" name="action" value="login">
        <button type="submit" class="btn btn-primary">Login</button>
        <a type="button" class="btn btn-primary" href="/login?action=signup" >Sign Up?</a>
        <a type="button" class="btn btn-primary" href="/login?action=changepassword" >Change password</a>
        <c:out value="${message}"></c:out>
    </form>
</div>
</body>
</html>