<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 07/09/2020
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>SIGN UP</h2>
    <form action="/login?action=signup" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" required>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
        </div>
        <input type="hidden" name="action" value="login">
        <a type="submit" class="btn btn-primary">Sign Up</a>
        <a type="button" class="btn btn-primary" href="/login">Back to login</a>
        <p><c:out value="status: ${status}"></c:out></p>
    </form>
</div>
</body>
</html>
