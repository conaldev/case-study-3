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
    <title> Sản Phẩm </title>
</head>
<body>
<center>
    <h1>Quản Lý Sản Phẩm</h1>
<%--    <input type="button" value="Thêm Sản Phẩm" href="product?action=create" onclick="" >--%>
    <h2><a  href="product?action=create">Thêm Sản Phẩm</a></h2>
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
                    <a href="product?action=sortASC">Giá thấp đến cao</a>
                    <a href="product?action=sortDESC"> Giá cao đến thấp</a>
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
    <h2><a  href="product?action=product">Quay lại</a></h2>
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
                    <a href="/product?action=update&id=${productList.id}">Edit</a> <br/>
                    <a href="/product?action=delete&id=${productList.id}">Delete</a>
                </td>
<%--                <td><input type="button" ></td>--%>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
