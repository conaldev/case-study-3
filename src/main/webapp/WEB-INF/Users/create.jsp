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
    <title>Chỉnh Sửa Thông Tin Tài Khoản</title>

</head>
<body>
<center>
    <h2>Thông tin tài khoản</h2>
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
                <th>Họ Tên </th>
                <td>
                    <input type="text" name=userFullName id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại</th>
                <td>
                    <input type="text" name="userPhoneNumber" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ</th>
                <td>
                    <input type="text" name="userAddress" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="userEmail" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Role code</th>
                <td>
                    <input type="text" name="roleCode" id="roleCole" size="45"/>
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
<h2><a href="users?action=users"> Quay Lại Danh Sách Tài Khoản</a></h2>
</body>
</html>
