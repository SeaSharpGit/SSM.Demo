<%--
  Created by IntelliJ IDEA.
  User: sea
  Date: 2019/8/21
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出</title>
</head>
<body>
    ${msg}
    <form action="save.action" method="post">
        ID：<input type="text" name="id"><br/>
        Name：<input type="text" name="name"><br/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
