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
        Date：<input type="text" name="date"><br/>
        <button type="submit">提交</button>
    </form>
</body>
</html>
