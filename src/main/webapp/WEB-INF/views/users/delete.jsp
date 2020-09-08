<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 08:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Delete User Confirm</h2></caption>
            <c:out value="${status}"></c:out>
            <c:if test="${user != null}">
                <tr>
                    <th>Number</th>
                    <th>Full Name</th>
                    <th>Phone Number</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Email</th>

                </tr>
                <tr>
                    <td><c:out value="${customer.getCusNumber()}"/></td>
                    <td><c:out value="${customer.userName}"/></td>
                    <td><c:out value="${customer.cusName}"/></td>
                    <td><c:out value="${customer.cusPhoneNumber}"/></td>
                    <td><c:out value="${customer.cusAddress}"/></td>
                    <td><c:out value="${customer.cusEmail}"/></td>
                </tr>
            </c:if>

        </table>
        <button type="submit">delete</button>
    </form>
</div>
</body>
</html>
