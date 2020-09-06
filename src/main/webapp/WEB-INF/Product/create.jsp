<%--
  Created by IntelliJ IDEA.
  User: Ideapad
  Date: 9/4/2020
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Thêm Sản Phẩm</title>

</head>
<body>
<center>
    <h2>Thêm Sản Phẩm</h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="6">
<%--           <tr>--%>
<%--               <th>Mã Sản Phẩm</th>--%>
<%--               <td>--%>
<%--                   <input type="text" name="id" id="id" size="45"/>--%>
<%--               </td>--%>
<%--           </tr>--%>
            <tr>
                <th>Tên Sản Phẩm</th>
                <td>
                    <input type="text" name="productName" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Giá Sản Phẩm</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Mô Tả</th>
                <td>
                    <input type="text" name="description" id="desc" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Link Hình Ảnh</th>
                <td>
                    <input type="text" name="imgUrl" id="img" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>
<h2><a href="product?action=product">Danh sách sản phẩm</a></h2>
</body>
</html>
