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
