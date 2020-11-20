<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/login_demo/login" method="post">
        <input type="text" name="loginId" placeholder="登录id" /><br>
        <input type="password" name="loginPwd" placeholder="登录密码" /><br>
        <input type="submit" name="登录" />
    </form>
</body>
</html>
