<style>
    table,table tr th, table tr td { border:1px solid #0094ff; }
    table { width: 800px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>

<h3><a href="/user/userList">用户列表</a></h3>
<h1>用户信息</h1>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>${user.userEmail}</td>
    </tr>
    <tr>
        <td>注册时间</td>
        <td>${user.createTime}</td>
    </tr>
</table>