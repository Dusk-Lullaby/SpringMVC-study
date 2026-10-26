<%--
  Created by IntelliJ IDEA.
  User: sonnet
  Date: 2026/10/25
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="button" value="按钮" id="testJson">

    <%--定义一个表单--%>
    <form action="${pageContext.request.contextPath}/demo2/testRequestEntity" method="post">
        用户名：<input type="text" name="username"> <br>
        用户密码：<input type="password" name="password"> <br>
        用户年龄：<input type="text" name="age"> <br>
        <input type="submit" value="提交">
    </form>
</body>
<script src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#testJson").click(function () {
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/demo2/testAjax",
                contentType:"application/json;charset=utf-8",
                data:'{"id":1, "name":"zhangsan", "money":1000.0}',
                dataType:"json",
                success:function (data) {
                    console.log(data);
                }
            })
        })
    })
</script>
</html>
