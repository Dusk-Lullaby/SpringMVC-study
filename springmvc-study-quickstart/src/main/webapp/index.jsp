<%--
  Created by IntelliJ IDEA.
  User: sonnet
  Date: 2026/10/22
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/hello">[搭建springmvc的入门案例]</a>

    <a href="${pageContext.request.contextPath}/demo1/getBasicParam?username=zhangsan&age=10">[提交基本类型的参数]</a>

    <form action="${pageContext.request.contextPath}/demo1/getPojoParams" method="post">
        账户编号：<input type="text" name="id"> <br>
        账户名称：<input type="text" name="name"> <br>
        账户金额：<input type="text" name="money"> <br>
        <input type="submit" value="提交">
    </form>

    <%--使用表单提交复杂类型数据--%>
    <form action="${pageContext.request.contextPath}/demo1/findUser" method="post">
        username:<input type="text" name="username"> <br>
        password:<input type="text" name="password"> <br>
        age:<input type="text" name="age"> <br>

        账户1名称：<input type="text" name="accountList[0].name"> <br>
        账户1金额：<input type="text" name="accountList[0].money"> <br>
        账户2名称：<input type="text" name="accountList[1].name"> <br>
        账户2金额：<input type="text" name="accountList[1].money"> <br>
        账户3名称：<input type="text" name="accountList[2].name"> <br>
        账户3金额：<input type="text" name="accountList[2].money"> <br>

        账户4名称：<input type="text" name="accountMap['one'].name"> <br>
        账户4金额：<input type="text" name="accountMap['one'].money"> <br>
        账户5名称：<input type="text" name="accountMap['two'].name"> <br>
        账户5金额：<input type="text" name="accountMap['two'].money"> <br>

        <input type="submit" value="提交">
    </form>

    <a href="${pageContext.request.contextPath}/demo1/getDate?date=2026-10-24">提交日期类型的数据</a>
    <br>
    <a href="${pageContext.request.contextPath}/demo1/getDate2?date=2026-10-24">提交日期类型的数据2</a>
    <br>
    <a href="${pageContext.request.contextPath}/demo1/testServletAPI?username=zhangsan&age=18">[测试原生servlet API]</a>
    <br>
    <a href="${pageContext.request.contextPath}/demo1/testRequestParam?username=jia&age=18">[测试RequestParam注解的使用]</a>
    <br>

    <%--编写一个表单，获取表单提交的实体内容--%>
    <form action="${pageContext.request.contextPath}/demo1/testRequestBody" method="post">
        用户名：<input type="text" name="username"> <br>
        用户密码：<input type="text" name="password"> <br>
        用户年龄：<input type="text" name="age"> <br>
        <input type="submit" value="保存">
    </form>

    <a href="${pageContext.request.contextPath}/demo1/testRequestHeader">[测试RequestHeader注解的使用]</a>
    <br>
    <a href="${pageContext.request.contextPath}/demo1/testCookieValue">[测试CookieValue注解]</a>
    <br>

    <a href="${pageContext.request.contextPath}/demo1/putSession">在session域中存储数据</a> <br>
    <a href="${pageContext.request.contextPath}/demo1/getSession">向session域中获取数据</a> <br>
    <a href="${pageContext.request.contextPath}/demo1/removeSession">清除session域中的数据</a> <br>

    <form action="${pageContext.request.contextPath}/demo1/showStudent" method="post">
        username:<input type="text" name="username"> <br>
        age:<input type="text" name="age"> <br>
        <input type="submit" value="提交">
    </form>

    <a href="${pageContext.request.contextPath}/demo1/testPathVariable/1001/jia">[测试PathVariable注解的使用]</a>
    <br>

    <a href="${pageContext.request.contextPath}/demo1/testMatrixVariable/1;name=jia;ages=10,11,12">[测试矩阵变量]</a>
    <br>

    <a href="${pageContext.request.contextPath}/demo1/testVoid">[返回值是void]</a>
    <br>
    <a href="${pageContext.request.contextPath}/demo1/testModelAndView">[返回值是ModelAndView]</a>
    <br>

    <a href="${pageContext.request.contextPath}/demo1/testRequest">[测试request作用域传值]</a> <br>
    <a href="${pageContext.request.contextPath}/demo1/testMap">[使用Map对象进行域对象的传值]</a> <br>
    <a href="${pageContext.request.contextPath}/demo1/testModel">[使用Model对象进行域对象的传值]</a> <br>
</body>
</html>
