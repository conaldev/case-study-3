<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 09:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Edit User </h2>
            </caption>
            <input type="hidden" name="userNumber" value="${requestScope["user"].getUserNumber()}"/>
            <a href="/users">Back To List Customer</a>
            <tr>
                <th>User Full Name:</th>
                <td>
                    <input type="text" name="userFullName" id="userFullName"
                           value="${requestScope["user"].getUserFullName()}" size="45" disabled/>
                </td>
            </tr>
            <tr>
                <th>User Phone Number:</th>
                <td>
                    <input type="text" name="userPhoneNumber" id="userPhoneNumber"
                           value="${requestScope["user"].getUserPhoneNumber()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="userAddress" id="userAddress"
                           value="${requestScope["user"].getUserAddress()}" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="userEmail" id="userEmail"
                           value="${requestScope["user"].getUserEmail()}" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
