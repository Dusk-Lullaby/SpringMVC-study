<%--
  Created by IntelliJ IDEA.
  User: sonnet
  Date: 2026/10/25
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/employee" name="_method">
        员工姓名：<input type="text" name="lastName" value="${employee.lastName}"> <br>
        员工邮箱：<input type="text" name="email" value="${employee.email}"> <br>
        员工性别：
        <c:if test="${employee.gender==1}">
            <input type="radio" name="gender" value="1" checked>male
            <input type="radio" name="gender" value="0">female <br>
        </c:if>
        <c:if test="${employee.gender==0}">
            <input type="radio" name="gender" value="1">male
            <input type="radio" name="gender" value="0" checked>female <br>
        </c:if>
        <input type="hidden" value="put" name="_method">
        <input type="submit" value="修改"> <br>
    </form>
</body>
</html>
