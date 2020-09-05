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
    <title>Productstitle>
</title>
<body>
<center>
    <h1>Quản Lý Sản Phẩm</h1>
    <h2><a  href="product?action=create">Thêm Sản Phẩm</a></h2>
</center>

<div align="center">
    <table border="1" cellpadding="6">
        <caption><h2>Danh sách sản phẩm</h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>ImgURL</th>
            <th>Action</th>
        </tr>
        <c:forEach var="productList" items="${productList}">
            <tr>
                <td><c:out value="${productList.id}"/></td>
                <td><c:out value="${productList.productName}"/></td>
                <td><c:out value="${productList.price}"/></td>
                <td><c:out value="${productList.description}"/></td>
                <td><c:out value="${productList.imgUrl}"/></td>
                <td>
                    <a href="/product?action=update&id=${productList.id}">Edit</a>
                    <a href="/product?action=delete&id=${productList.id}">Delete</a>
                </td>
<%--                <td><input type="button" ></td>--%>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
