<%--
  Created by IntelliJ IDEA.
  User: Ideapad
  Date: 9/4/2020
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title> Users </title>
</head>
<body>
<center>
    <h1>Quản Lý Tài Khoản Khách hàng</h1>
<%--    <input type="button" value="Thêm Sản Phẩm" href="product?action=create" onclick="" >--%>
<%--    <h2><a  href="users  ?action=create"></a></h2>--%>
</center>
<table cellpadding="2" width="100%">
    <tr>
        <td>
            <div align="left">
                <form method="post">
                    <h3>Search  </h3>
                    <input type="hidden" name="action" value="search">
                    <input type="text" name="id" value="" placeholder="Id, Name">
                    <input type="submit" value="Search">
                </form>
            </div>
        </td>

        <td>
            <div align="right">
                <form method="get">
                    <h3>Sắp Xếp</h3>
                    <a href="users?action=sortName">Sắp xếp theo tên</a>
<%--                    <a href="product?action=sortDESC"> Giá cao đến thấp</a>--%>
<%--                    <select name="dropdown">--%>
<%--                        <option type="" name="action" value="sortASC"><a href="/users?action=sortASC">Giá thấp đến cao</a></option>--%>
<%--                        <option type="" name="action" value="sortDESC"><a href="/users?action=sortDESC"> Giá cao đến thấp</a> </option>--%>
<%--                    </select>--%>
                </form>
            </div>
        </td>

    </tr>
</table>

<%--<input href="product?action=product" type="button" value="Quay lại">--%>
    <h2><a  href="users?action=users">Quay lại</a></h2>
<div align="center">
    <table border="1" cellpadding="7">
        <caption><h2>Danh Sách Tài Khoản</h2></caption>
        <tr>
            <th>Mã số</th>
            <th>Họ Tên</th>
            <th>Số Điện Thoại</th>
            <th>Địa Chỉ</th>
            <th>Email</th>
            <th>RoleCode</th>
            <th>Chức Năng</th>
        </tr>
        <c:forEach var="usresList" items="${usersList}">
            <tr>
                <td><c:out value="${usresList.userNumber}"/></td>
                <td><c:out value="${usresList.userFullName}"/></td>
                <td><c:out value="${usresList.userPhoneNumber}"/></td>
                <td><c:out value="${usresList.userAddress}"/></td>
                <td><c:out value="${usresList.userEmail}"/></td>
                <td><c:out value="${usresList.roleCode}"/></td>
                <td>
                    <a href="/usres?action=update&id=${usresList.userNumber}">Edit</a>
                    <a href="/usres?action=delete&id=${usresList.userNumber}">Delete</a>
                </td>
<%--                <td><input type="button" ></td>--%>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
