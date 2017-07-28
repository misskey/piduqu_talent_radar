
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>成都市郫都区人才资源统计分析系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=10;IE=9;IE=8;IE=7;IE=EDGE">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${ctx!}/assets/img/favicon.ico" type="image/x-icon">
    <link  href="${ctx!}/assets/css/style.css"rel="stylesheet"/>
    <link href="${ctx!}/assets/css/theme.css"rel="stylesheet"/>
    <script src="${ctx!}/assets/lib/config.js" type="text/javascript"></script>
</head>
<body>
<div id="maincontainer">
    <div id="navigation" class="clearfix">
    <#include "header.ftl"/>
    </div>

    <div id="content-container" class="x-container clearfix">

        <div class="container">
            <div class="row-fluid search_page">
                <div class="span12">
                    <div class="well clearfix">
                        <p class="fl mt20 "><b class="mr5 A_username">郫县</b><span class="cr3 A_isAdmin">管理员</span></p>

                        <div class="fr mt15 clearfix">
                            <a class="btn btn-primary mr5 J_password_btn">修改密码</a>

                        </div>
                    </div>

                    <div class="search_panel clearfix  mt20" style="display: block;">

                        <ul class=" pos_tab">
                            <li class="active "><a href="#tab1" _t="1"
                                                   data-toggle="tab">账号信息</a>
                            </li>
                            <li><a href="#tab2" _t="2"
                                   data-toggle="tab">团队成员</a>
                            </li>


                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane clearfix active" id="tab1">
                                <div class="clearfix mb10">
                                    <p class="fb fl mt10">账号管理</p>
                                    <a class="btn btn-border fr J_add_AccountDia">添加账号</a>
                                </div>
                                <div class="A_accountList">
                                    <div class="A_accountList">


                                        <div class="pos_item set_item

                            setSelect

                            clearfix">

                                            <p class="icon icon-nowAccount"></p>

                                            <div class=" fl mr10">
                                                <img src="../images/pic/4.png" class="pos_logo">

                                            </div>
                                            <div class=" fl  mt10" style="width: 40%">

                                                <p class="fb  cr3  u-tt-more" title="市委组织部">市委组织部</p>

                                                <p class="cr3   ">35个用户</p>

                                            </div>


                                        </div>

                                        <div class="pos_item set_item

                            clearfix">

                                            <p class="icon icon-nowAccount"></p>

                                            <div class=" fl mr10">
                                                <img src="../images/pic/1.png" class="pos_logo">

                                            </div>
                                            <div class=" fl  mt10" style="width: 40%">

                                                <p class="fb  cr3  u-tt-more" title="没有">没有</p>

                                                <p class="cr3   ">0个用户</p>

                                            </div>

                                            <a class="btn btn-default fr set_out_btn J_delete_account" _id="001143001">删除账户</a>


                                        </div>

                                        <div class="pos_item set_item

                            clearfix">

                                            <p class="icon icon-nowAccount"></p>

                                            <div class=" fl mr10">
                                                <img src="../images/pic/2.png" class="pos_logo">

                                            </div>
                                            <div class=" fl  mt10" style="width: 40%">

                                                <p class="fb  cr3  u-tt-more" title="tes">tes</p>

                                                <p class="cr3   ">0个用户</p>

                                            </div>

                                            <a class="btn btn-default fr set_out_btn J_delete_account" _id="001142001">删除账户</a>


                                        </div>

                                    </div>
                                </div>


                            </div>
                            <div class="tab-pane clearfix" id="tab2">
                                <div>
                                    <div id="A_memberList">


                                        <div class="pos_item set_item   clearfix">

                                            <div class=" fl mr10">
                                                <img src="../images/pic/4.png" class="pos_logo">

                                            </div>
                                            <div class=" fl  mt10" style="width: 40%">
                                                <div class=" ">
                                                    <p class="fb  cr3 u-tt-more mb0" title="市委组织部">
                                                        市委组织部</p>

                                                    <p class="cr3 f12 u-tt-more mb0" title="">
                                                    </p>

                                                    <p class="cr3   f12">

                                                        管理员

                                                    </p>
                                                </div>


                                            </div>

                                        </div>

                                        <div class="pos_item set_item   clearfix">

                                            <div class=" fl mr10">
                                                <img src="../images/pic/4.png" class="pos_logo">

                                            </div>
                                            <div class=" fl  mt10" style="width: 40%">
                                                <div class=" ">
                                                    <p class="fb  cr3 u-tt-more mb0" title="我哦哦">
                                                        我哦哦</p>

                                                    <p class="cr3 f12 u-tt-more mb0" title="3894839@qq.com">
                                                        3894839@qq.com</p>

                                                    <p class="cr3   f12">

                                                        团队成员

                                                    </p>
                                                </div>


                                            </div>

                                            <a class="btn btn-border fr set_out_btn J_delMember_btn" _id="054">移除该成员</a>

                                        </div>

                                    </div>
                                    <a class="fl J_add_member">
                                        <img src="../images/add.png">
                                    </a>

                                </div>
                            </div>

                            <div id="kkpager"></div>
                        </div>


                    </div>

                </div>
            </div>

        </div>
        <div id="dialog">
        <#include "listDialog.ftl">

        </div>

    </div>




</div>
</body>
<script  src="${ctx!}/assets/lib/require/require.js"></script>
<script type="text/javascript">
    require(['${ctx!}/script/setting.js','common'],
            function ( sw_setting) {
                sw_setting.ready();
            });

</script>
</html>


