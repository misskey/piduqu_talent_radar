<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx!}/assets/layui/css/layui.css">
</head>
<body>

<div>


</div>
<!-- 你的HTML代码 -->
<@shiro.hasPermission name="user:userList:*">
<a href="/loginPage">登录</a></br>
</@shiro.hasPermission>
<a href="/loginPage">登录</a></br>
<a href="/loginOut">登出</a>
</body>
</html>