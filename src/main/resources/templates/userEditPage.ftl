<style>
    table,table tr th, table tr td { border:1px solid #0094ff; }
    table { width: 800px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>

<h3><a href="/user/userList">用户列表</a></h3>
<h1>编辑用户</h1>
<form method="post" action="${ctx!}/user/userUpdate" id="frm">
<table border="1">
    <input type="hidden" name="id" id="id" value="${user.id}" />
    <tr>
        <td>用户名</td>
        <input type="hidden" name="userName" id="userName" value="${user.userName}" />
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="text" name="userEmail" id="userEmail" value="${user.userEmail}" /></td>
    </tr>
    <tr>
        <td>注册时间</td>
        <td>${user.createTime}</td>
    </tr>
    <tr>
        <td>操作</td>
        <td><button>确定</button></td>
    </tr>
</table>
</form>