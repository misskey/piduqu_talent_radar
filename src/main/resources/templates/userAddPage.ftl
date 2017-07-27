<style>
    table,table tr th, table tr td { border:1px solid #0094ff; }
    table { width: 800px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>

<h3><a href="/user/userList">用户列表</a></h3>
<h1>添加用户</h1>
<form method="post" action="${ctx!}/user/userAdd" id="frm">
    <table border="1">
        <input type="hidden" name="id" id="id" value="${user.id}" />
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName" id="userName" placeholder="用户名" /></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input type="text" name="userEmail" id="userEmail" placeholder="邮箱" /></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="userPhone" id="userPhone" placeholder="电话" /></td>
        </tr>
        <tr>
            <td>操作</td>
            <td><button>确定</button></td>
        </tr>
    </table>
</form>