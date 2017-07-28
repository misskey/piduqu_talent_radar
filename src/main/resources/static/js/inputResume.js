/**
 * Created by Administrator on 2017/5/4.
 */
define([
    "msg",
    "beanUtil",
    "dic",
    "validator",
    "multilevelpicker",
    "selectControl",
    'datetimepicker',
    "datetimepickerZh",
    'colorbox'
],function(msg, sw_beanUtil, sw_dic,sw_validator,multilevelpicker,selectControl){
    var sw_inputReume = {
        selectMap : {},
        tId:'',
        industryfield:[],
        ready:function(param){
            $("#viewOverlay").remove();
    
            this.initSelect();
            this.initdatepicker();
            this.initDomListener();
            this.initCityPicker();
            this.initTradePicker();
        },

        initdatepicker:function(){
            $("#I_birthday").datetimepicker({
                format: "yyyy-mm-dd",
                autoclose: true,
                language: 'zh-CN',
                startView: 'month',
                minView:'month',
                maxView:'decade',
                endDate:new Date()
            })

        },
        initDomListener:function(){
            var me  =  this;
            $(".J_expert_type").click(function(e){
                $(".expertType-div").slideToggle();
                e.stopPropagation();
            });
            $(document).bind('click',function(e){
                var target = $(e.target);
                if(target.closest("#demodiv").length == 0){/*外部元素*/
                    $(".expertType-div").slideUp();
                }

            });
            /*确定人才级别*/
            var industry_field = []
            $(".J_sure_expertType").click(function(){
                me.industryfield= []
                $("#demodiv cite").each(function(ind,val){
                    if($(val).hasClass('checked')){
                        industry_field.push($(val).attr('_text'))
                        me.industryfield.push($(val).attr('_val'))
                    }
                })
                $("#I_expert_type").val(industry_field.toString())
                $(".expertType-div").slideUp();
            })
            /*保存*/
            $(".J_save").click(function(){
                me.save();
            })

            $(document).on("click.a", ".J_del_domRight", function () {
                $(this).parents('.add_otherRight_input').remove();
            })
            $(document).on("click.a", ".J_del_domleft", function () {
                $(this).parents("div[name='parent_dom']").remove();
            })

            $(".J_addinputresume").on("click", function (e) {
                e.preventDefault();
                me.addinputresume(this);
            });
            this.delDom();
        },
        delDom:function(){
            //删除节点
            $(".J_del_dom").off().on("click", function(){
                var _that = this;
                $(_that).parent("div[name='parent_dom']").remove();


            })

        },
        addinputresume: function (obj) {
            if($(obj).attr("for-dom") == 'project_dom'){

            }
            this.cloneNode('',$(obj).attr("for-dom"),obj);

        },
        cloneNode: function (_data, nodeId, i) {

            var node = $("#"+nodeId)
            var parentNode =  $("#"+nodeId+"_parent");
                $("#exp_dom .education,#exp_dom .work").hide();
                $("#exp_dom .project_dom_parent").empty();

            var cloneNode =  node.clone(true);
               cloneNode.find("input").val('');
                cloneNode.find("textarea").text('');

            var len =$("." + node.attr("id")).length ;
            var start_date = cloneNode.find("input[name='start_date']");
            var end_date = cloneNode.find("input[name='end_date']");
            start_date.attr("id", start_date.attr("id") + len);
            end_date.attr("id", end_date.attr("id") + len);
            cloneNode.find(".del_dom").removeClass("hide")
            //学历下拉框
            var edu_dom = cloneNode.find("input[name='degree']").parents(".select-warp");
            edu_dom.attr("id", edu_dom.attr("id") + len);

            var exp_dom = cloneNode.find("input[name='exp']").parents(".select-warp");
            exp_dom.attr("id", exp_dom.attr("id") + len);

            cloneNode.attr("id", node.attr("id")+len);

            if(nodeId == 'project_dom'){
                $(i).siblings('.project_dom_parent').append(cloneNode).show();
            }else{
                $("."+nodeId+"_parent").append(cloneNode).show();
            }


            start_date.datetimepicker({
                format: "yyyy-mm-dd",
                autoclose: true,
                language: 'zh-CN',
                startView: 'month',
                minView:'month',
                maxView:'decade',
                endDate:new Date()
            }).on('changeDate', function (ev) {
                $(this).blur();
                $(document).click();
            })
            end_date.datetimepicker({
                format: "yyyy-mm-dd",
                autoclose: true,
                language: 'zh-CN',
                startView: 'month',
                minView:'month',
                maxView:'decade',
                endDate:new Date()
            }).on('changeDate', function (ev) {
                $(this).blur();
                $(document).click();
            })



            this.initSelect();
            if(edu_dom.length > 0 ){
                this.selectMap[edu_dom.attr("id")] = new selectControl(
                    {
                        domId: edu_dom.attr("id"), //必填
                        options:sw_dic.systemDicMap[edu_dom.attr("_type")],//必填
                        width: 191,//下拉宽度
                        defaultVal:edu_dom.find(".select-value").val(),
                        event: {
                            onchange: function (obj, value, text, _that) {
                            }
                        }
                    });
            }
return;

        },
        save:function(){
            var me = this;
            if (this.isSumbit) {
                return;
            }
            var vaild = sw_validator.autoValidator($(".search_page"));
            if (!vaild) {
                alertDIV('请填写完整')
                return;
            }
            jTip('保存成功');
        },
        getListBean: function (node,type) {
            var arr = [];
            var arr1 = [];
            if(type == 1){
                if ($("#" + node).is(":visible")) {
                    node = $("." + node);
                } else {
                    node = $("." + node).not("#" + node)
                }
            }else{
                node = $("." + node);
            }

            $.each(node, function () {
                var obj = {};

                var _node = $(this).find(".dom_bean");

                $.each(_node, function (i,j) {

                    if($(_node[i]).attr("name") == 'contentList'){

                        arr1.length = 0
                        var nextdom = $(this).find('.next_dom');
                        $.each(nextdom,function(){
                            arr1.push($(this).val())

                        })
                        $(this).val(arr1)
                    }
                    obj[$(this).attr("name")] = $(this).val();
                })
                arr.push(obj);
            });
            return arr;
        },
        initCityPicker:function(){
            var me = this;
            //城市选择器
            if(me.selectMap.citypicker){
                return;
            }
            me.selectMap["citypicker"] = new multilevelpicker({
                domId:"citypicker",
                //data:cityAll,
                html:$('.cityl'),
                width:400,
                callback: function(obj){
                    me.cityobj = obj;
                    $("#I_living").parent().find(".select-text").text(obj.first+obj.second+obj.third);
                    $("#I_living").val(obj.first+obj.second+obj.third);
                    $("#I_city").val(obj.second);
                }
            });
        },
        initTradePicker: function(){
            this.selectMap["enterprise_picker"] = new multilevelpicker({
                domId:"enterprise_picker",
                //data:cityAll,
              html:$('.trad'),
                width:300,
                callback: function(obj){
                    $("#enterprise_picker").find(".select-text").text(obj.third);
                    $("#enterprise_picker").find(".select-value").val(obj.third);

                }
            });
        },
        initPage: function (all, force, pno, pageCount) {
            var me = this;
            var total = (all % pageCount === 0) ? all / pageCount : (all / pageCount + 1);
            // 生成分页
            new page({
                pagerid: "kkpager",
                pno: pno,
                // 总页码
                total: total,
                totalRecords: all,
                mode: 'click',// 默认值是link，可选link或者click
                enforceInit: force,
                click: function (page) {
                    this.selectPage(page);
                    var param = {
                        force: false,
                        page: page,
                        condition:$('#search_val').val()
                    }
                    me.initData(param);
                }
            });
        },
        initSelect:function(){
            var me = this;

            $(".J_select_exp").each(function () {
                var type = $(this).attr("_type");
                var p2 = {
                    domId: this.id, //必填
                    options: sw_dic.systemDicMap[type],//必填
                    width: '100%',//下拉宽度
                    isDefaultTitle: true,
                    defaultVal: $(this).find(".select-value").val(),
                    event: {
                        onchange:function (event) {
                            /*0 j 1 g*/
                            if($(event).attr("_value") == 0){
                                $(".work").hide();
                                $(".education").show();
                            }else{
                                $(".work").show();
                                $(".education").hide();
                            }
                        }
                    }
                };
                me.selectMap[this.id] = new selectControl(p2);
            })
            $(".J_select_wrap").each(function () {
                var type = $(this).attr("_type");
                var p1 = {
                    domId: this.id, //必填
                    options: sw_dic.systemDicMap[type],//必填
                    width: 247,//下拉宽度
                    isDefaultTitle: false,
                    defaultVal: $(this).find(".select-value").val(),
                    event: {
                        onchange: function (obj, value, text) {
                        }
                    }
                };
                me.selectMap[this.id] = new selectControl(p1);
            });
        }
    }
    return sw_inputReume;
})