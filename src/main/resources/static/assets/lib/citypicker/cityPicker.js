define(["/commonjs/plugins/citypicker/cityUtil.js"],function(cityUtil){
    var iplocation = cityUtil.iplocation;
    var districtJSON = cityUtil.districtJSON;
    var provinceCityJson = cityUtil.provinceCityJson;
    return (function($){
        $.fn.extend({
            generateCityPicker:function(option){
                var _self = this;

                //检测this后的第一个input节点是否含有class city-selector-text
                var domId = this.attr("id");
                if(!$("#"+domId+">input").hasClass(".city-selector-text")){
                    $("#"+domId+">input").addClass("city-selector-text")
                }

                if(!this.hasClass("city-selector")){
                    this.addClass("city-selector");
                }
                var $provence = $(_self._getProvincesDom());
                this.find(".city-selector-text").after($provence);
                $("#stock_province_item .area-list").append(_self._getProvincesList());
              /*  $("#stock_city_item .area-list").append(_self._getareaList());*/
                //事件绑定
                if(option != undefined && option.unbind == true){
                    this._unbindEvent();
                }
                else{
                    this._bindEvent(option);
                }

                this.setWidth();
            },

            _unbindEvent : function(){
                var _self = this;
                _self.find('.content').remove();
                this.find(".city-selector-text").unbind('click');
            },
            _bindEvent:function(option){
                var _self = this;

                var areaTabContainer = _self.find("#JD-stock .tab li");
                var provinceContainer = _self.find("#stock_province_item");
                var cityContainer = _self.find("#stock_city_item");
                var areaContainer = _self.find("#stock_area_item");
                var townaContainer = _self.find("#stock_town_item");
                var currentAreaInfo;

                this.find(".city-selector-text").bind("click",function (event){
                    _self.toggleClass('hover');
                    _self.find(".content").toggle();
                });

                _self.find("#stock_province_item a ").hover(function(){
                    _self.unbind("mouseout");
                    _self._chooseProvince(this,option);
                });
                var ci = _self;
                areaTabContainer.find(".J_province").off().bind("click",function(){
                    areaTabContainer.removeClass("curr");
                    $(this).parent().addClass("curr").show();
                    provinceContainer.show();
                    cityContainer.hide();
                    areaContainer.hide();
               /*     areaTabContainer.find(".J_city").parent().hide();*/
                });
                areaTabContainer.find(".J_city").click(function () {
                    areaTabContainer.removeClass("curr");
                    $(this).parent().addClass("curr").show();
                   // provinceContainer.hide();
                    cityContainer.show();
                    areaContainer.hide();
                });

  areaTabContainer.find(".J_area").click(function () {
                    areaTabContainer.removeClass("curr");
                    $(this).parent().addClass("curr").show();
                    //provinceContainer.hide();
                    cityContainer.hide();
                    areaContainer.show();
                });

                //点击文档其他地方，隐藏下拉选择
                $(document).on('mousedown',function(e){
                    var event = $.event.fix(e);
                    var $jqCity = $(event.target).closest('.city-selector');
                    if($jqCity.length > 0){
                        return false;
                    }
                    if(_self.find(".content").is(":visible") == true) {
                        _self.find(".content").hide();
                    }
                });

                //_self.mousedown(function(event){
                //    event.stopPropagation();
                //});
            },
            setWidth:function(){
                var _width = this.find(".city-selector-text").outerWidth();

                this.find(".content").width(_width );
            },
            _getProvincesList:function(){
                var domArr = [];
                $.each(iplocation,function(key,value){
                    var node = '<li><a href="javascript:void(0);" data-type="'+value["id"]+'" data-value="'+key+'">'+key+'</a></li>';
                    domArr.push(node);
                });

                return domArr.join("");
            },
            _getAreaList:function(result, provinceId){
                var me = this;
                var html = ["<ul class='area-list'>"];
                var longhtml = [];
                var longerhtml = [];
                if (result && result.length > 0) {
                    for (var i = 0, j = result.length; i < j; i++) {
                        result[i].name = result[i].name.replace(" ", "");
                            html.push("<li><a href='javascript:void(0);' data-type='"+result[i].id+"' data-value='"+result[i].name+"' ><strong>" + result[i].name + "</strong></a>")
                            var idlist=provinceCityJson[provinceId][i];console.log(idlist);
                            html.push('<ul>');
                            $.each(idlist.child, function(t){
                                    html.push("<li><a href='javascript:void(0);' data-type='"+idlist.child[t].id+"' data-value='"+idlist.child[t].name+"' >" + idlist.child[t].name + "</a>")
                                })
                            html.push('</ul>');
                        html.push("</li>");
                    }
                }
                else {
                    html.push("<li><a href='javascript:void(0);'> </a></li>");
                }
                html.push(longhtml.join(""));
                html.push(longerhtml.join(""));
                html.push("</ul>");
                return html.join("");
            },
            _chooseProvince:function(obj,option) {
                var _self = this;
                var provinceContainer = _self.find("#stock_province_item");
                var cityContainer = _self.find("#stock_city_item");
                var areaContainer = _self.find("#stock_area_item");
                var areaTabContainer = _self.find("#JD-stock .tab li");
                var provinceName = _self.find(obj).attr("data-value");
                var provinceId = _self.find(obj).attr("data-type");


                if (provinceCityJson["" + provinceId]) {
                    //provinceContainer.hide();
                    cityContainer.html(_self._getAreaList(provinceCityJson["" + provinceId],provinceId));

                    areaTabContainer.removeClass("curr");
                    areaTabContainer.find(".J_province em").text(provinceName);
                    areaTabContainer.eq(1).addClass("curr").show();
                   // provinceContainer.hide();
                    cityContainer.show();
                    cityContainer.find("a").bind("click",function () {
                        cityContainer.hide();
                        areaTabContainer.removeClass("curr");
                        areaTabContainer.find(".J_city em").text($(this).attr("data-value"));
                        areaTabContainer.eq(2).addClass("curr").show();
                        var areaId=$(this).attr("data-type");
                        var a=provinceCityJson["" + provinceId]
                        for(var i =0;i<a.length;i++){
                            var idlist=provinceCityJson[provinceId][i];
                                if(idlist.id == areaId){
                                    areaContainer.html(_self._getAreaList( idlist.child));
                                    areaContainer.show();
                                    areaContainer.find("a").bind("click",function () {
                                        _self._getCityText(this,option);
                                    });

                                    return;
                                }

                        }
                       /* _self._getCityText(this,option);*/
                    });
                }else{
                    cityContainer.html(_self._getAreaList(districtJSON["" + provinceId]));

                    areaTabContainer.removeClass("curr");
                    areaTabContainer.find(".J_province em").text(provinceName);
                    areaTabContainer.find(".J_city em").text('请选择');
                    areaTabContainer.eq(1).addClass("curr").show();
                    areaTabContainer.eq(2).hide();
                   // provinceContainer.hide();
                    cityContainer.show();
                    areaContainer.hide();
                    cityContainer.find("a").bind("click",function () {
                        _self._getCityText(this,option);
                    });
                    //_self._getCityText(obj,option);
                }
                this.setPosition();
            },
            setPosition: function(){
                var _width = this.find(".city-selector-text").outerWidth();
                this.find("#stock_city_item").css("left",_width);
            },
            _getCityText:function(obj,option){
                var _self = this;
                var pcaText;
                var opt = $.extend({} , _self.defaults , option);
                var J_province=$(".tab .J_province em").text();
                var J_city=$(".tab .J_city em").text();
                var J_area=$(obj).text();
                if(J_city == '请选择'){
                    J_city = '';
                }
                pcaText = J_province + J_city + J_area;

                _self.find(".city-selector-text").val(pcaText);
                _self.find(".city-selector-text").attr("province",J_province);
                _self.find(".city-selector-text").attr("J_city",J_city);
                _self.find(".city-selector-text").attr("J_area",J_area);
                opt.onSelected(pcaText);
                //解决选中城市时验证提示不会消失的问题，jquery验证为失焦验证
                _self.find(".city-selector-text").blur();
                this.removeClass('hover');
                this.find(".content").hide();
            },
            _getProvincesDom:function(){
                var provinceHtml = '<div class="content" style="display:none;"><div data-widget="tabs" class="m JD-stock" id="JD-stock">'
                    + '<div class="mt" style="display:none;">'
                    + '    <ul class="tab">'
                    + '        <li class="curr"><a href="javascript:void(0);" class="hover J_province"><em>请选择</em><i></i></a></li>'
                    + '        <li style="display:none;"><a href="javascript:void(0);" class="J_city"><em>请选择</em><i></i></a></li>'
                    + '        <li style="display:none;"><a href="javascript:void(0);" class="J_area"><em>请选择</em><i></i></a></li>'
                    + '    </ul>'
                    + '    <div class="stock-line"></div>'
                    + '</div>'
                    + '<div class="mc" id="stock_province_item">'
                    + '    <ul class="area-list">'
                        // + '       <li><a href="javascript:void(0);" data-type="1">北京</a></li><li><a href="javascript:void(0);" data-type="1">上海</a></li><li><a href="javascript:void(0);" data-type="1">天津</a></li><li><a href="javascript:void(0);" data-type="1">重庆</a></li><li><a href="javascript:void(0);" data-value="5">河北</a></li><li><a href="javascript:void(0);" data-value="6">山西</a></li><li><a href="javascript:void(0);" data-value="7">河南</a></li><li><a href="javascript:void(0);" data-value="8">辽宁</a></li><li><a href="javascript:void(0);" data-value="9">吉林</a></li><li><a href="javascript:void(0);" data-value="10">黑龙江</a></li><li><a href="javascript:void(0);" data-value="11">内蒙古</a></li><li><a href="javascript:void(0);" data-value="12">江苏</a></li><li><a href="javascript:void(0);" data-value="13">山东</a></li><li><a href="javascript:void(0);" data-value="14">安徽</a></li><li><a href="javascript:void(0);" data-value="15">浙江</a></li><li><a href="javascript:void(0);" data-value="16">福建</a></li><li><a href="javascript:void(0);" data-value="17">湖北</a></li><li><a href="javascript:void(0);" data-value="18">湖南</a></li><li><a href="javascript:void(0);" data-value="19">广东</a></li><li><a href="javascript:void(0);" data-value="20">广西</a></li><li><a href="javascript:void(0);" data-value="21">江西</a></li><li><a href="javascript:void(0);" data-value="22">四川</a></li><li><a href="javascript:void(0);" data-value="23">海南</a></li><li><a href="javascript:void(0);" data-value="24">贵州</a></li><li><a href="javascript:void(0);" data-value="25">云南</a></li><li><a href="javascript:void(0);" data-value="26">西藏</a></li><li><a href="javascript:void(0);" data-value="27">陕西</a></li><li><a href="javascript:void(0);" data-value="28">甘肃</a></li><li><a href="javascript:void(0);" data-value="29">青海</a></li><li><a href="javascript:void(0);" data-value="30">宁夏</a></li><li><a href="javascript:void(0);" data-value="31">新疆</a></li><li><a href="javascript:void(0);" data-type="1">台湾</a></li><li><a href="javascript:void(0);" data-type="1">香港</a></li><li><a href="javascript:void(0);" data-type="1">澳门</a></li>'
                    + '    </ul>'
                    + '</div>'
                    + '<div class="mc" id="stock_city_item"></div>'
                    + '<div class="mc" id="stock_area_item"></div>'
                    + '</div></div>';
                return provinceHtml;
            },
            defaults : {
                onSelected : function(city){return false;}
            }
        })
    })(jQuery);
})






