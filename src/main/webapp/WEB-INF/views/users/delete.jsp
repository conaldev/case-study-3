<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Delete User Confirm</h2></caption>
            <a href="/users">Back to UserList</a>
            <c:out value="${status}"></c:out>
            <c:if test="${user != null}">
                <tr>
                    <th>Number</th>
                    <th>Full Name</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Email</th>

                </tr>
                <tr>
                    <td><c:out value="${user.getUserNumber()}"/></td>
                    <td><c:out value="${user.getUserFullName()}"/></td>
                    <td><c:out value="${user.getUserPhoneNumber()}"/></td>
                    <td><c:out value="${user.getUserAddress()}"/></td>
                    <td><c:out value="${user.getUserEmail()}"/></td>
                </tr>
            </c:if>

        </table>
        <button type="submit">delete</button>
    </form>
</div>
</body>
</html>
