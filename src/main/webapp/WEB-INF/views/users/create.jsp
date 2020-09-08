<%--
  Created by IntelliJ IDEA.
  User: conal
  Date: 08/09/2020
  Time: 08:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>NEW USER </h2>
            </caption>
            <a href="/users">back to list users</a></br>
            <a href="/login">back to login</a>
            <tr>
                <th>User Full Name:</th>
                <td>
                    <input type="text" name="userFullName" id="userFullName" size="50" required/>
                </td>
            </tr>
            <tr>
                <th>Full Name:</th>
                <td>
                    <input type="text" name="cusName" id="cusName" size="50" required/>
                </td>
            </tr>
            <tr>
                <th>PhoneNumber:</th>
                <td>
                    <input type="text" name="userPhoneNumber" id="userPhoneNumber" size="50" />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="userAddress" id="userAddress" size="50"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="email" name="userEmail" id="userEmail" size="50"/>
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
