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
    <h2>Cập nhật Thông Tin </h2>
</center>
<div align = "center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${showUpdate != null}">
                <input type="hidden" name="id"
                       value="<c:out value='${showUpdate.userNumber}'/>"/>
            </c:if>
            <tr>
                <th>Họ Tên</th>
                <td>
                    <input type="text" name="userFullName" size="45"
                    value="<c:out value='${showUpdate.userFullName}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại</th>
                <td>
                    <input type="text" name="userPhoneNumber" size="45"
                           value="<c:out value='${showUpdate.userPhoneNumber}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ</th>
                <td>
                    <input type="text" name="userAddress" size="45"
                           value="<c:out value='${showUpdate.userAddress}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Email</th>
                <td>
                    <input type="text" name="userEmail" size="45"
                           value="<c:out value='${showUpdate.userEmail}'/> "/>
                </td>
            </tr>
            <tr>
                <th>Role Code</th>
                <td>
                    <input type="text" name="roleCode" size="45"
                           value="<c:out value='${showUpdate.roleCode}'/> "/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
    <h2><a href="users?action=users"> Quay Lại Danh Sách Tài Khoản</a></h2>
</div>

</body>
</html>
