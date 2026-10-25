<%--
  Created by IntelliJ IDEA.
  User: sonnet
  Date: 2026/10/25
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>展示员工信息</title>
    <style>
        table {
            background-color: orange;
            width: 600px;
            margin: 0 auto;
            border-spacing: 1px;
        }
        table tr {
            text-align: center;
            background-color: white;
        }
        table th,
        table td {
            padding: 4px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th colspan="5">员工信息</th>
        </tr>
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>邮箱</th>
            <th>性别</th>
            <th>操作<a href="/pages/add.jsp">新增</a></th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.lastName}</td>
                <td>${employee.email}</td>
                <td>${employee.gender}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/employee/${employee.id}" method="post">
                        <input type="hidden" name="_method"  value="delete">
                        <input type="submit" value="删除">
                    </form>
                    <form action="${pageContext.request.contextPath}/employee/${employee.id}" method="get">
                        <input type="submit" value="更新">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
