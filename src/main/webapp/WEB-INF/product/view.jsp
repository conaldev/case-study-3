<%--
  Created by IntelliJ IDEA.
  User: Ideapad
  Date: 9/4/2020
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productstitle>
</head>
<body>
<center>
    <h1>Quản Lý Sản Phẩm</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách sản phẩm</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Vendor</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach value="" items="{$}"></c:forEach>
        <tr>
            <td></td>
        </tr>
    </table>
</div>
</body>
</html>
