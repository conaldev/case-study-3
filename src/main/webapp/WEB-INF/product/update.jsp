<%--
  Created by IntelliJ IDEA.
  User: Ideapad
  Date: 9/4/2020
  Time: 5:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Cập Nhật</title>
</head>
<body>
<center>
    <h2>Cập nhật Thông Tin Sản Phẩm</h2>
</center>
<div align = "center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${showUpdate != null}">
                <input type="hidden" name="id"
                       value="<c:out value='${showUpdate.id}'/>"/>
            </c:if>
            <tr>
                <th>Tên sản phẩm</th>
                <td>
                    <input type="text" name="productName" size="45"
                    value="<c:out value='${showUpdate.productName}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Giá sản phẩm</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${showUpdate.price}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Mô Tả</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${showUpdate.description}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Link Hình Ảnh</th>
                <td>
                    <input type="text" name="imgUrl" size="45"
                           value="<c:out value='${showUpdate.imgUrl}'/> "/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    <h2><a href="product?action=product">Danh Sách Sản Phẩm </a></h2>
</div>

</body>
</html>
