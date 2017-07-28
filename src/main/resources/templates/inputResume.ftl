<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>成都市郫都区人才资源统计分析系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=10;IE=9;IE=8;IE=7;IE=EDGE">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${ctx!}/assets/img/favicon.ico" type="image/x-icon">
    <link href="${ctx!}/assets/css/style.css" rel="stylesheet"/>
    <link href="${ctx!}/assets/css/theme.css" rel="stylesheet"/>
    <script src="${ctx!}/assets/lib/config.js" type="text/javascript"></script>
</head>
<body>
<div id="maincontainer">
    <div id="navigation" class="clearfix">
    <#include "header.ftl">
    </div>

    <div id="content-container" class="x-container clearfix">

        <!-- 人才录入-->
        <div class="container">
            <div class="row-fluid search_page" style="    border: 1px solid #dfdfdf;">
                <div class="span12">
                    <div class="well clearfix">
                        <p class="pull-left mt10 ">人才录入</p>
                    </div>
                    <div class="search_panel clearfix  mt20">
                        <div class="ir-top clearfix">

                            <img class="fl" src="../images/t.png" style="margin-right: 10px;">
                            <div class="fl mr10 mt15">
                                <span class=" mr5">姓名:</span>
                                <input class="input" id="I_name" placeholder="姓名或全名" errorTipsKey="姓名或全名"
                                       validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules"/>
                            </div>
                            <div class="fl mt20">
                                <span class=" mr5">性别:</span>
                                <span id="I_gender">
                            <input type="radio" name="sex" checked value="女"/>女
                            <input type="radio" name="sex" value="男"/>男
                        </span>

                            </div>


                        </div>

                        <div class="ir-con inputResume mt20">
                            <ul class="pos_tab">
                                <li class="active"><a href="#tab1" data-toggle="tab">基础信息</a></li>
                                <li class=""><a href="#tab2" data-toggle="tab">个人简历</a></li>
                                <li class=""><a href="#tab6" data-toggle="tab">个人描述</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab1">
                                    <div class="clearfix">
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label>出生日期<span class="required-span">*</span></label>
                                            <input type="text" id="I_birthday" class="input input-info" readonly
                                                   placeholder="出生日期">
                                        </div>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label>年龄<span class="required-span">*</span></label>
                                            <input type="text" class="input input-info" readonly placeholder="年龄">
                                        </div>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">学历<span class="required-span">*</span></label>

                                            <div class="select-warp select-input J_select_wrap" id="J_educationType"
                                                 _type="educationType">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value dom_bean" name="degree"
                                                       validator="notNullOrEmptySelect" errorTipsKey="学历"
                                                       removeDefaultRules="removeDefaultRules" id="I_educationType"/>
                                            </div>
                                        </div>

                                        <div class="form-group fl mr20">
                                            <label>电话<span class="required-span">*</span></label>
                                            <input type="text" id="I_phone" class="input input-info" placeholder="电话"
                                                   validator="telPhone" errorTipsKey="手机号码">
                                        </div>

                                    </div>

                                    <div class="clearfix">

                                        <div class="form-group fl mr20">
                                            <label>Email</label>
                                            <input type="text" id="I_email" class="input input-info" placeholder="Email"
                                                   errorTipsKey="Email" validator="email"
                                                   removeDefaultRules="removeDefaultRules">
                                        </div>
                                        <div class="form-group fl mr20">
                                            <label>政治面貌<span class="required-span">*</span></label>
                                            <input type="text" class="input input-info" placeholder="政治面貌">
                                        </div>
                                        <div class="form-group fl mr20">
                                            <label>民族<span class="required-span">*</span></label>
                                            <input type="text" class="input input-info" placeholder="民族">
                                        </div>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">国籍<span class="required-span">*</span></label>

                                            <div class="select-warp select-input J_select_wrap" id="J_state"
                                                 _type="state">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value dom_bean" name="degree"
                                                       validator="notNullOrEmptySelect" errorTipsKey="状态"
                                                       removeDefaultRules="removeDefaultRules" id="I_state"/>
                                            </div>
                                        </div>

                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">现居地<span class="required-span">*</span></label>
                                            <div class="select-warp select-input  select-picker" id="citypicker">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value"
                                                       id="I_living2"/>
                                            </div>
                                        </div>
                                        <input type="hidden" id="I_city"/>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">出生地/籍贯<span class="required-span">*</span></label>

                                            <div class="select-warp select-input  select-picker" id="citypicker">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value"
                                                       id="I_living"/></div>
                                        </div>

                                        <div class="form-group fl mr20 form-width-sm  select-picker"
                                             id="enterprise_picker">
                                            <label class="f14">所属行业/领域<span class="required-span">*</span></label>

                                            <div class="select-warp select-input">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value"
                                                       validator="notNullOrEmptySelect"
                                                       errorTipsKey="所属行业/领域" removeDefaultRules="removeDefaultRules"
                                                       id="I_industry_field"/>
                                            </div>
                                        </div>
                                        <div class="form-group fl form-width-sm pr J_expertType_div">
                                            <label class="f14">人才级别<span class="required-span">*</span></label>
                                            <input placeholder="人才级别" id="I_expert_type" readonly
                                                   class="input input-info J_expert_type" errorTipsKey="人才级别"
                                                   validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules"/>
                                            <input type="hidden" id="I_expert_type1"/>
                                            <div class="f12  expertType-div " id="demodiv" style="display: none">
                                                <div class="J_filter_two">
                                                    <b class="f14 mb10">国内高端人才</b>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="0"
                                                                               _text="中国科学院院士"></cite>中国科学院院士</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="1"
                                                                               _text="中国工程院院士"></cite>中国工程院院士</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="2"
                                                                               _text="“国千”人才"></cite>“国千”人才</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="3"
                                                                               _text="“国万”人才"></cite>“国万”人才</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="4"
                                                                               _text="长江学者"></cite>长江学者</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="5"
                                                                               _text="国家百千万人才"></cite>国家百千万人才</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="6"
                                                                               _text="国家杰出青年"></cite>国家杰出青年</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="7"
                                                                               _text="百人计划"></cite>百人计划</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="8"
                                                                               _text="院校（TOP100）教授"></cite>院校（TOP100）教授
                                                    </p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm" _val="9"
                                                                               _text="研究员"></cite>研究员</p>

                                                </div>
                                                <div class="J_filter_three">
                                                    <b class="f14 mb10">国外高端人才</b>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm"
                                                                               _val="10" _text="诺贝尔奖"></cite>诺贝尔奖</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm"
                                                                               _val="11" _text="图灵奖"></cite>图灵奖</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm"
                                                                               _val="12" _text="菲尔兹奖"></cite>菲尔兹奖</p>
                                                    <p class="check_box"><cite type="checkbox" class="check_sm"
                                                                               _val="13" _text="院校（TOP100）教授"></cite>院校（TOP100）教授
                                                    </p>

                                                </div>
                                                <a class="btn btn-primary J_sure_expertType">确定</a>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="clearfix">


                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">十支人才类别<span class="required-span">*</span></label>

                                            <div class="select-warp select-input J_select_wrap" id="J_nvq1"
                                                 _type="nvq1">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value dom_bean" name="degree"
                                                       validator="notNullOrEmptySelect" errorTipsKey="十支人才类别"
                                                       removeDefaultRules="removeDefaultRules" id="I_nvq1"/>
                                            </div>
                                        </div>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">职业资格<span class="required-span">*</span></label>

                                            <input class="input input-info"/>
                                        </div>
                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">职称<span class="required-span">*</span></label>
                                            <input class="input input-info"/>
                                        </div>


                                        <div class="form-group fl mr20 form-width-sm">
                                            <label class="f14">状态<span class="required-span">*</span></label>

                                            <div class="select-warp select-input J_select_wrap" id="J_state"
                                                 _type="state">
                                                <label class="select-text">请选择</label>
                                                <input type="hidden" class="defaultValue"/>
                                                <input type="hidden" class="select-value dom_bean" name="degree"
                                                       validator="notNullOrEmptySelect" errorTipsKey="状态"
                                                       removeDefaultRules="removeDefaultRules" id="I_state"/>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="clearfix">


                                    </div>
                                </div>
                                <div class="tab-pane" id="tab2">
                                    <div class="add_exp_model exp_dom_parent">

                                    </div>
                                    <a class="btn-href J_addinputresume" for-dom="exp_dom">+添加经历</a>


                                </div>


                                <div class="tab-pane" id="tab6">

                                    <textarea class="textatea" placeholder="请输入个人描述"
                                              id="I_self_introduction"></textarea>


                                </div>

                            </div>
                        </div>
                        <div class="dialog-btn fr">
                            <button class="btn btn-default J_cancel_dialog">取消</button>
                            <button class="btn btn-primary J_save">保存</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div style="display:none;">
            <div id="exp_dom" class="exp_dom" name="parent_dom">
                <div class="clearfix">
                    <div class="form-group fl mr20 form-width-sm">
                        <label class="f14">经历类型</label>
                        <div class="select-warp select-input J_select_exp" id="J_exp"
                             _type="exp">
                            <label class="select-text">请选择</label>
                            <input type="hidden" class="defaultValue"/>
                            <input type="hidden" class="select-value dom_bean" name="exp"
                                   validator="notNullOrEmptySelect" errorTipsKey="学历"
                                   removeDefaultRules="removeDefaultRules"/>
                        </div>
                    </div>
                    <div class="form-group fl mr20 form-width-sm">
                        <label>起始时间</label>
                        <input type="text" name="start_date" id="IT_start_date" readonly style="width: 40%"
                               class="input input-info dom_bean date" placeholder="起始时间">

                        <input type="text" name="end_date" id="IT_end_date" readonly style="width: 40%"
                               class="input input-info dom_bean date" placeholder="起始时间">
                    </div>

                </div>
                <div class="education" style="display:none;">


                    <div class="clearfix">

                        <div class="form-group fl form-width-sm">
                            <label class="f14">院校</label>
                            <input type="text" name="college_name" class="input input-info dom_bean"
                                   placeholder="院校">
                        </div>

                        <div class="form-group fl mr20">
                            <label>专业</label>
                            <input type="text" name="profession_name" class="input input-info dom_bean"
                                   placeholder="专业">
                        </div>


                        <div class="form-group fl mr20 form-width-sm">
                            <label class="f14">学历</label>

                            <div class="select-warp select-input J_select_wrap" id="J_experienceType"
                                 _type="educationType">
                                <label class="select-text">请选择</label>
                                <input type="hidden" class="defaultValue"/>
                                <input type="hidden" class="select-value dom_bean" name="degree"
                                       validator="notNullOrEmptySelect" errorTipsKey="学历"
                                       removeDefaultRules="removeDefaultRules"/>
                            </div>
                        </div>

                    </div>

                </div>
                <div class="work" style="display:none;">

                    <div class="clearfix">
                        <div class="form-group fl mr20">
                            <label>职位名称</label>
                            <input type="text" name="position_name" class="input input-info dom_bean"
                                   placeholder="职位名称">
                        </div>


                    </div>
                    <div class="clearfix">
                        <label>工作描述</label>
                        <textarea class="textatea dom_bean" placeholder="工作描述"
                                  name="experience_desc"></textarea>

                    </div>

                </div>

                <div class="project mt20" style="    background: rgba(235, 236, 238, 0.48); padding: 20px;">
                    <p class="fb cr1">项目经历:</p>
                    <div class="add_project_model project_dom_parent" class="projectmode" style="display: none">

                    </div>
                    <a class="btn-href J_addinputresume " for-dom="project_dom">+添加项目经历</a>
                </div>
                <a class="btn-href J_del_dom ">删除</a>
            </div>


            <div id="project_dom" class="project_dom" name="parent_dom">
                <div class="clearfix">
                    <div class="form-group fl mr20 form-width-sm">
                        <label>起始时间</label>
                        <input type="text" name="start_date" id="ITP_start_date" readonly style="width: 40%"
                               class="date input input-info dom_bean"
                               placeholder="起始时间">
                        <input type="text" name="end_date" id="ITP_end_date" readonly style="width: 40%"
                               class="date input input-info dom_bean"
                               placeholder="起始时间">
                    </div>
                    <div class="form-group fl mr20">
                        <label>项目名称</label>
                        <input type="text" name="project_name" class="input input-info dom_bean" placeholder="项目名称">
                    </div>

                </div>

                <div class="clearfix">
                    <label>项目描述</label>
                    <textarea class="textatea dom_bean" placeholder="项目描述" name="project_desc"></textarea>

                </div>
                <a class="btn-href J_del_dom ">删除</a>
            </div>

        </div>

    </div>


</div>
<div id="dialog">
<#include "listDialog.ftl">

</div>

</body>
<script src="${ctx!}/assets/lib/require/require.js"></script>
<script type="text/javascript">
    require(['${ctx!}/js/inputResume.js', 'common'],
            function (sw_inputReume) {
                sw_inputReume.ready();
            });

</script>
</html>





