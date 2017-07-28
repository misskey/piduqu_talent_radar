<div class="row-fluid search_page">
    <div class="span12">

        <div class="well clearfix">
            <div class="fr mt15 clearfix">
                <a class="btn btn-border mr5 J_filter_btn">筛选</a>
                <a class="btn btn-border mr10 J_sendMsg_btn">发消息</a>
                <a class="btn btn-border mr10">导出</a>

            </div>
        </div>
        <div class="ss-model" style="display:none;">

            <div class="ss-model-con">


                <p class="f18 tc mb20">人才筛选</p>
                <div class="clearfix mb20">
                    <div class="form-group fl mr20">
                        <label>姓名</label>
                        <input type="text" class="input input-info" placeholder="姓名" errorTipsKey="姓名" >
                    </div>

                    <div class="form-group fl mr20">
                        <label>联系方式</label>
                        <span >
                            <input type="radio" name="sex" checked value="是"/>是
                            <input type="radio" name="sex" value="否"/>否
                        </span>

                    </div>
                    <div class="form-group fl mr20">
                        <label>所在公司</label>
                        <input type="text" class="input input-info" placeholder="所在公司" >
                    </div>
                    <div class="form-group fl mr20 form-width-sm  select-picker" id="enterprise_picker">
                        <label class="f14">所属行业/领域<span class="required-span">*</span></label>

                        <div class="select-warp select-input">
                            <label class="select-text">请选择</label>
                            <input type="hidden" class="defaultValue"/>
                            <input type="hidden" class="select-value" validator="notNullOrEmptySelect"
                                   errorTipsKey="所属行业/领域" removeDefaultRules="removeDefaultRules"
                                   id="I_industry_field"/>
                        </div>
                    </div>

                </div>

                <div class="clearfix">
                    <div class="form-group fl mr20">
                        <label>年龄</label>
                        <input type="text" class="input input-info input-sm" placeholder="年龄" >
                        -
                        <input type="text"class="input input-info input-sm" placeholder="年龄"  >
                    </div>

                    <div class="form-group fl mr20  form-width-sm pr J_expertType_div" >
                        <label class="f14">人才级别<span class="required-span">*</span></label>
                        <input placeholder="人才级别"  id="I_expert_type"  readonly class="input input-info J_expert_type" errorTipsKey="人才级别"
                               validator="notNullOrEmpty" removeDefaultRules="removeDefaultRules"/>
                        <input  type="hidden" id="I_expert_type1"/>
                        <div class="f12  expertType-div " id="demodiv"style="display: none">
                            <div class="J_filter_two">
                                <b class="f14 mb10">国内高端人才</b>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="0" _text="中国科学院院士"></cite>中国科学院院士</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="1" _text="中国工程院院士"></cite>中国工程院院士</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="2" _text="“国千”人才"></cite>“国千”人才</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="3" _text="“国万”人才"></cite>“国万”人才</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="4" _text="长江学者"></cite>长江学者</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="5" _text="国家百千万人才"></cite>国家百千万人才</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="6" _text="国家杰出青年"></cite>国家杰出青年</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="7" _text="百人计划"></cite>百人计划</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="8" _text="院校（TOP100）教授"></cite>院校（TOP100）教授</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="9" _text="研究员"></cite>研究员</p>

                            </div>
                            <div class="J_filter_three">
                                <b class="f14 mb10">国外高端人才</b>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="10" _text="诺贝尔奖"></cite>诺贝尔奖</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="11" _text="图灵奖"></cite>图灵奖</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="12" _text="菲尔兹奖"></cite>菲尔兹奖</p>
                                <p class="check_box"><cite type="checkbox" class="check_sm" _val="13" _text="院校（TOP100）教授"></cite>院校（TOP100）教授</p>

                            </div>
                            <a class="btn btn-primary J_sure_expertType" >确定</a>
                        </div>

                    </div>
                    <div class="form-group fl mr20 form-width-sm">
                        <label class="f14">居住地</label>

                        <div class="select-warp select-input  select-picker" id="citypicker">
                            <label class="select-text">请选择</label>
                            <input type="hidden" class="defaultValue"/>
                            <input type="hidden" class="select-value"
                                   id="I_living"/></div>
                    </div>
                    <button class="btn btn-primary tc mt20">确定</button>

                </div>
            </div>


        </div>

        <div class="search_panel clearfix " style="display: block;">
            <div id="A_talentList">
                <table class="table table-striped" data-provides="rowlink">
                    <thead>
                    <tr>
                        <th><cite type="checkbox" id="select_all"  _type="0" class="pay-check mr10 check_sm"></cite>全选</th>
                        <th>姓名</th>
                        <th>行业</th>
                        <th>人才级别</th>
                        <th>年龄</th>
                        <th>居住地</th>
                        <th>出生地/籍贯</th>
                        <th>联系方式</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr class="rowlink J_open_talentDetail" >
                        <td>
                            <cite type="checkbox" class="pay-check mt15 select_child mr10  check_sm" _value="1"></cite>

                            <img class="list-logo fl" src="${ctx!}/assets/img/p.png">
                        </td>
                        <td>张三</td>
                        <td>电子信息</td>
                        <td>中国工程院院士</td>
                        <td>35</td>
                        <td>成都</td>
                        <td>成都</td>
                        <td>1326565666</td>

                    </tr>
                    <tr class="rowlink J_open_talentDetail">
                        <td>
                            <cite type="checkbox" class="pay-check mt15 select_child mr10  check_sm" _value="1"></cite>

                            <img class="list-logo fl" src="${ctx!}/assets/img/p.png">
                        </td>
                        <td>张三</td>
                        <td>电子信息</td>
                        <td>中国工程院院士</td>
                        <td>35</td>
                        <td>成都</td>
                        <td>成都</td>
                        <td>1326565666</td>

                    </tr>

                    </tbody>
                </table>



            </div>


        </div>

    </div>
</div>
