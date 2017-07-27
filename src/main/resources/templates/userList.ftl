<style>
    table,table tr th, table tr td { border:1px solid #0094ff; }
    table { width: 800px; min-height: 25px; line-height: 25px; text-align: center; border-collapse: collapse;}
</style>

<h3><a href="/user/userAddPage">添加用户</a></h3>
用户名：<@shiro.principal type="com.piduqu.radar.entity.User" property="userName"/>
<h1>用户列表</h1>
<table border="1">
    <form method="post" action="${ctx!}/user/userList" id="frm">
        <tr align="right">
            <td colspan="6"><input type="text" name="searchText" id="searchText" value="${searchText}" placeholder="用户名" />
                <input type="submit" value="搜索"/></td>
        </tr>
    </form>
    <tr>
        <td>用户名</td>
        <td>邮箱</td>
        <td>状态</td>
        <td>注册时间</td>
        <td>修改时间</td>
        <td>操作</td>
    </tr>
<#list userList as user>
    <tr>
        <td>${user.userName}</td>
        <td>${user.userEmail}</td>
        <td>${user.userStatus}</td>
        <td>${user.createTime}</td>
        <td>${user.updateTime}</td>
        <td>
            <a href="/user/userInfo?id=${user.id}">查看</a>
            <a href="/user/userEditPage?id=${user.id}">修改</a>
            <#if user.userStatus != 1>
                <a href="/user/userDelete?id=${user.id}">删除</a>
            </#if>
        </td>
    </tr>
</#list>
</table>
