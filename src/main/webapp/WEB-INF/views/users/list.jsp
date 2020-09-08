<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<div class="container" align="center">
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New Customer</a>
    </h2>
    <div class="container">
        <form method="get" action="/users">
            <input type="text" name="SearchName">
            <input type="submit" name="action" value="Search">
        </form>
    </div>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>User Number</th>
                <th>Full Name</th>
                <th>Phone Number</th>
                <th>Address</th>
                <th>Email</th>
                <th>Actions</th>

            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                        <td><c:out value="${user.userNumber}"/></td>
                        <td><c:out value="${user.userFullName}"/></td>
                        <td><c:out value="${user.userPhoneNumber}"/></td>
                        <td><c:out value="${user.userAddress}"/></td>
                        <td><c:out value="${user.userEmail}"/></td>
                    <td>
                        <a href="/users?action=edit&userNumber=${user.userNumber}">Edit</a>
                        <a href="/users?action=delete&userNumber=${user.userNumber}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
