<table>
<#list userList as user>
    <tr>
        <td>${user.userName}</td>
        <td>${user.userEmail}</td>
        <td>${user.createTime}</td>
    </tr>
</#list>
</table>