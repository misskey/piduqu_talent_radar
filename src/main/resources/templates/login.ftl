<#--<form method="post" action="${ctx!}/login" id="frm">
    <h4>登录1：</h4>
    <input type="text" name="username" id="username" placeholder="用户名" />
    <input type="password" name="password" id="password"  placeholder="密码" />
    <button>登录</button>
</form>-->
<!DOCTYPE HTML>
<html lang="en" class="login_page">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="${ctx!}/assets/img/favicon.ico" type="image/x-icon">
    <title>成都市郫都区人才资源统计分析系统</title>
    <link rel="stylesheet" type="text/css" href="${ctx!}/assets/css/login.css"/>
</head>
<body>
<img src="${ctx!}/assets/img/bg.png" class="bg-login">
<div id="login_wrapper">
    <div id="login_content" class="pr">
        <div class="top_b">LOGO</div>
        <div class="logon-text">郫县</div>
        <div class="login_box">
            <div  id="login_form">

                <div class="alert alert-error alert-login" style="display:none"></div>
                <div class="cnt_b">
                    <div class="formRow">
                        <div class="input-prepend">
                            <span class="add-on fl"><i class="icon icon-cellphone-iphone "></i></span>
                            <input type="text" id="login_userName" class="fl" value="" name="account" validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules" placeholder="机构或企业名/Email"  errorTipsKey="用户名" />
                        </div>
                    </div>
                    <div class="formRow mt10">
                        <div class="input-prepend">
                            <span class="add-on fl"><i class="icon icon-lock"></i></span>
                            <input type="password"   value="" class="fl" id="login_userPassword" name="password" validator="notNullOrEmpty" placeholder="密码" errorTipsKey="密码"/>
                        </div>
                    </div>


                </div>
                <div class="btm_b clearfix">
                    <button class="pull-right login-btn"  id="J_login" type="submit">登录</button>
                </div>
                <p style="text-align: center;margin: 10px 0px;">
                    <a style="text-decoration: underline;font-size: 12px;" href="#">忘记密码？</a>
                </p>
            </div>
        </div>
    </div>
</div>



<script src="${ctx!}/assets/lib/config.js"></script>
<script src="${ctx!}/assets/lib/require/require.js"></script>
<script type="text/javascript">
    require(["jquery"], function($){
        $('#J_login').on('click',function(){
            window.location.href="${ctx!}/dashboard";

        });

        $(document).on('keydown', function(e){
            if(e.keyCode == 13){
                $("#login_login_email").blur();

                $('#J_login').click();
            }
        });
    })
</script>
</body>
</html>
