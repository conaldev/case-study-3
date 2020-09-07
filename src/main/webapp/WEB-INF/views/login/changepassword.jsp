<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 07/09/2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form method="post" action="/login?action=changepassword" >
        <div class="form-group">
            EMAIL:<br>
            <input type="text" class="form-control" placeholder="Enter username" name="username" required><br>
            mat khau hien tai<br>
            <input type="password" class="form-control" placeholder="Enter password" name="password" required><br>
            mat khau moi<br>
            <input type="password" class="form-control" placeholder="Enter newpassword" name="newpassword" required><br>
            <button type="submit" class="btn btn-primary">submit</button>
            <button type="reset" class="btn btn-primary">reset</button>
            <a type="button" class="btn btn-primary" href="/login">Login</a>
            <p><c:out value="status: ${status}"></c:out></p>
        </div>
    </form>
</div>

</body>
</html>
