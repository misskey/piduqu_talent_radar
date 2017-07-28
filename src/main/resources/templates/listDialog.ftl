<!--发送消息-->
<div style="display: none">
    <div class="sendMsg_dialog pd20 clearfix" id="sendMsg_dialog"   title="发送消息">
        <div >
            <div class="clearfix">
                <label>发送给</label>
                <p class="A_sendName clearfix" style="min-height:40px;max-height:100px;overflow-y: auto">
                </p>

            </div>
            <div class="form-group">
                <label>主题</label>
                <input type="text" class="input input-info w" id="send_title" placeholder="主题">
            </div>
            <div >
                <label>消息内容</label>
                <textarea class="textatea" id="send_content"></textarea>
            </div>
        </div>


        <div class="dialog-btn mt20 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_sendMessage_sure">发送</button>
        </div>
    </div>
</div>

<!--添加部门或企业账号-->
<div style="display: none">
    <div class="addAccount_dialog pd20 clearfix" id="addAccount_dialog" title="添加部门或企业账号">
        <div class="form-group">
            <label>机构或企业名称<span class="cr3">（该账号将会被默认为管理员）</span></label>
            <input type="text" class="input input-info w"  id="a_userName" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="机构或企业名称"  errorTipsKey="机构或企业名称">
        </div>


        <div class="dialog-btn mt10 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_add_account">创建</button>
        </div>
    </div>
</div>
<!--修改密码-->
<div style="display: none">
    <div class="changePassword_dialog pd20 clearfix" id="changePassword_dialog" title="修改密码">
        <div class="form-group">
            <label>原密码</label>
            <input type="password" class="input input-info w" id="pwd_userPassword" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="原密码"  errorTipsKey="原密码">
        </div>
        <div class="form-group">
            <label>新密码</label>
            <input type="password" class="input input-info w" id="pwd_new_pwdagain" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="新密码"  errorTipsKey="新密码">
        </div>
        <div class="form-group">
            <label>再次输入新密码</label>
            <input type="password" class="input input-info w"  id="pwd_new_pwd" validator="notNullOrEmpty same" removeDefaultRules="removeDefaultRules "  equalTo="#pwd_new_pwdagain"  errorTipsKey="密码">
        </div>

        <div class="dialog-btn mt10 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_sure_pwd">确定</button>
        </div>
    </div>
</div>

<!--添加 邀请团队成员-->
<div style="display: none">
    <div class="addTeam_dialog pd20 clearfix" id="addTeam_dialog" title="邀请团队成员">
        <div class="form-group">
            <label>用户名称</label>
            <input type="text" class="input input-info w" id="s_userName" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="用户名称"  errorTipsKey="用户名称">
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="text" class="input input-info w" id="s_userEmail" validator="notNullOrEmpty email" removeDefaultRules="removeDefaultRules" placeholder="Email"  errorTipsKey="Email">
        </div>

        <div class="dialog-btn mt10 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_addTeam_sure" >发送邀请</button>
        </div>
    </div>
</div>
<!--添加角色-->
<div style="display: none">
    <div class="addrole_dialog pd20 clearfix" id="addrole_dialog" title="添加角色">
        <div class="form-group">
            <label>角色名称</label>
            <input type="text" class="input input-info w" id="a_roleName" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="角色名称"  errorTipsKey="角色名称">
            <p class="cr9 f12">添加角色后请点击右侧对应权限设置按钮进行权限匹配。</p>
        </div>

        <div class="dialog-btn mt10 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_sure_roleBtn">添加</button>
        </div>
    </div>
</div>
<!--权限-->
<div style="display: none">
    <div class="purview_dialog pd20 clearfix" id="purview_dialog" title="权限设定">
        <div id="A_roleListSet">

            <div class="purview_div">
                <label class="mb20">数据分析</label>
                <p class="check_box">

                    <span><cite type="checkbox" class="check_sm

                    " roleid="1"></cite>数据分析</span>

                </p>

            </div>

            <div class="purview_div">
                <label class="mb20">职位管理</label>
                <p class="check_box">

                    <span><cite type="checkbox" class="check_sm

                    " roleid="5"></cite>发布职位</span>

                    <span><cite type="checkbox" class="check_sm

                    " roleid="7"></cite>协作记录</span>

                </p>

            </div>

            <div class="purview_div">
                <label class="mb20">系统设定</label>
                <p class="check_box">

                    <span><cite type="checkbox" class="check_sm

                            checked

                    " roleid="10"></cite>角色管理</span>

                    <span><cite type="checkbox" class="check_sm

                            checked

                    " roleid="8"></cite>账号信息</span>

                    <span><cite type="checkbox" class="check_sm

                            checked

                    " roleid="9"></cite>团队成员</span>

                </p>

            </div>

        </div>

        <div class="dialog-btn mt20 fr">
            <a class="btn-href mr20 J_cancel_dialog" >取消</a>
            <button class="btn btn-primary J_sure_purview">保存</button>
        </div>
    </div>
</div>

<!--简历上传 导入-->
<div style="display: none">
    <div class="excelFileUpload_dialog pd20 clearfix" id="excelFileUpload_dialog" title="简历上传导入">
        <div class="upload-model">
            <img src="../images/upload.png">
            <p class="f18 mt30">请点击上传简历文件</p>
            <p class="cr9">仅支持Excel等文件</p>
            <button class="btn btn-primary mt30" onclick="$('#uploadExcel').click()">上传文件</button>
            <input type="file" id="uploadExcel" class="mt30" name="file" style="display: none"/>
        </div>
    </div>
</div>