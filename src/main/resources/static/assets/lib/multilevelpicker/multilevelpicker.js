define(["util","mCustomScrollbar"],
    function (sw_util,mCustomScrollbar) {

        var multilevelpicker = function (config) {
            this.container = $("#"+config.domId);
            this.option = config;

            this.init();
        }

        multilevelpicker.prototype = {
            init: function () {
                var me = this;
                //为了提高速度，使用util.js中的createMultilevelSelectHTML生成html的步骤修改为加载静态页面
                this.appendHtml()
                this.initEvent();
                this.setValue();
            },
            appendHtml: function(){

                this.container.append(this.option.html);
                var w = this.option.width || this.container.width();
                this.container.find(".options-picker").width(w);
        /*        this.container.find(".picker-next-level").width(w-10);*/
                this.container.find(".picker-next-level").css("left",'0');
             /*   this.setLeft(w);*/

            },
            setLeft:function(w){
                var offleft = this.container.offset().left;
                var offpicker = this.container.find(".options-picker").width();
                var offthree = this.container.find(".picker-three-level").width()+12;
                var  allwidth = offleft + offpicker +offthree ;
                var  clientWidth =  document.body.clientWidth;
                if(clientWidth > allwidth){/*所需宽度  小于 屏幕宽度 就可以向右*/
                    console.log('向右');
                    this.container.find(".picker-next-level").css("left",w);
                }else{/* 相反 所需宽度  大于 屏幕宽度 就可以向右*/
                    console.log('向左');
                    var  leftw = w +32;
                    this.container.find(".picker-next-level").css("left",'-'+leftw+'px');
                }
            },
            setValue: function(value){
                var _value = value || this.container.find(".select-value").val();
                if(_value){
                    this.container.find(".select-text").text(_value);
                }
            },
            initEvent: function () {
                var me = this;
                $(".first-level-content").mCustomScrollbar();
                $(".picker-next-level").mCustomScrollbar();

               /* this.container.find(".picker-first-level").on("mouseover", function(){
                    $(".picker-next-level").css("display","none");
                    var _title = $(this).find('.li-text').text();
                    var index = $(this).index();
                    me.container.find(".picker-next-level").eq(index).css('display','block');
                    //$(".picker-next-level[_title="+_title+"]").css('display','block');
                    $(".picker-first-level").removeClass("p-hover");
                    $(this).addClass("p-hover")
                })*/
                this.container.find(".picker-first-level").on("click", function(event){
                    if(event.target.className == 'p-hover clone-hover'){
                        $(event.target).remove();
                        $(".picker-next-level").css("display","none");
                    }else{
                        if(event.target.className == 'clone-hover' ){
                            $(event.target).remove();
                            $(".picker-next-level").css("display","none");
                        }else if( event.target.parentElement.className == 'clone-hover'){
                            $(event.target.parentElement).remove();
                            $(".picker-next-level").css("display","none");
                        }else if(event.target.parentElement.className == 'p-hover clone-hover'){
                            $(event.target.parentElement).remove();
                            $(".picker-next-level").css("display","none");
                        }else{
                            var clone=$(this).clone(true).addClass("clone-hover").removeClass("picker-first-level");
                            /* $(this).parent().prepend(clone);*/
                            $(this).parent().before(clone);
                            $(".picker-next-level").css("display","none");
                            var _title = $(this).find('.li-text').text();
                            var index = $(this).index();

                            me.container.find(".picker-next-level").eq(index).css('display','block');
                        }

                    }

                    //$(".picker-next-level[_title="+_title+"]").css('display','block');
                    $(".picker-first-level").removeClass("p-hover");
                    $(this).addClass("p-hover")
                })

                this.container.find(".text-option").on("click", function(){
                    if( me.option.callback){
                        me.option.callback({
                            "first":$(this).attr("f-data"),
                            "second":$(this).attr("s-data"),
                            "third":$(this).find(".li-text").text()
                        });
                    }
                    $(".clone-hover").remove();
                    me.container.find(".options-picker").css("display","none");
                    me.resetNode();
                })

                $(document).off("mousedown.mp").on('mousedown.mp',function(e){
                    var event = $.event.fix(e);

                    var $jqCity = $(event.target).closest('.select-picker');
                    if($jqCity.length > 0){
                        return false;
                    }
                    $(".clone-hover").remove();
                    $(".options-picker").hide();
                    $(".picker-next-level").hide();
                });

                this.container.find(".select-text").on("mousedown", function(){
                    //隐藏其他下拉框
                    $(".options-warp").hide();

                    $(".options-picker").not(me.container.find(".options-picker")).hide();
                    me.container.find(".options-picker").toggle();
                    return false;

                })

                $(window).resize(function(){
                    me.appendHtml();
                });

            },
            unbindEvent: function(){
                this.container.find(".select-text").off().css("background-color",'#CECECE');
            },
            resetNode: function () {
                $(".picker-first-level").removeClass("p-hover");
                $(".picker-next-level").css("display","none");
            }
        }

        return multilevelpicker;
    })