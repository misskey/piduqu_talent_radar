
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
            <ul class="db-top clearfix">
                <li class="h-number">
                    <div class="fl">
                        <i class="icondemo icon-01 fl"></i>
                    </div>
                    <div class="fl">
                        <p class="cr3 f30">62354</p>
                        <p class="cr3 f12">新增人才（过去一个月)</p>
                    </div>
                </li>
                <li class="h-number">
                    <div class="fl">
                        <i class="icondemo icon-02"></i>
                    </div>
                    <div class="fl">
                        <p class="cr3 "><span class="f30">123456</span><span class="f12">万</span></p>
                        <p class="cr3 f12">人才库（共计）</p>
                    </div>
                </li>
                <li class="h-number">
                    <div class="fl">
                        <i class="icondemo icon-03"></i>
                    </div>
                    <div class="fl">
                        <p class="cr3 f30">20</p>
                        <p class="cr3 f12">团队成员（共计）</p>
                    </div>
                </li>
            </ul>

            <div class="tabbable tabbable-bordered mt20 pr roleSet_1" _role="1" >
                <ul class="nav nav-tabs">
                    <li class="active "><a href="#tab_br1" data-toggle="tab"><i class="icondemo icon-07"></i>人才信息统计</a></li>
                    <li  ><a href="#tab_br2" data-toggle="tab"><i class="icondemo icon-08"></i>人才管理</a></li>

                </ul>


                <div class="tab-content " style="max-height:700px;">

                    <div class="tab-pane active " id="tab_br1" >

                        <div id="view1" class="piemodel"  _atyp="1"></div>
                        <div id="view2" class="piemodel "  _atyp="2"></div>
                        <div id="view3" class="piemodel"  _atyp="3" ></div>
                        <div id="view4" class="piemodel"  _atyp="4"></div>
                    </div>
                    <div class="tab-pane  "  id="tab_br2">

                      <#include "talentList.ftl">
                    </div>



                </div>
            </div>
        </div>




    </div>




</div>
<div id="dialog">

<#include "listDialog.ftl">
</div>

<div id="view">
<#include "talentDetails.ftl">
</div>
</body>
<script  src="${ctx!}/assets/lib/require/require.js"></script>
<script type="text/javascript">
    require(['${ctx!}/js/dashboard.js','${ctx!}/js/talentList.js','common'],
            function ( sw_dashboard,sw_talentList) {
                sw_dashboard.ready();
                sw_talentList.ready();
            });

</script>
</html>

