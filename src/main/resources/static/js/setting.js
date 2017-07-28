/**
 * Created by Administrator on 2017/5/8.
 */
/**
 * Created by Administrator on 2017/5/5.
 */
define([
    'selectControl',
    "beanUtil",
    'colorbox'
],function(selectControl,sw_beanUtil){
    var sw_setting = {
        selectMap : {},
        param:{
            user_id:$('#user_id').val(),
            page:1
        },
        ready:function(){
            var _hash = window.location.hash;
            $.each($(".accordion-toggle"), function(){
                var _href = $(this).attr("href");
                if(_hash.indexOf(_href) > -1 ){
                    var parentNode = $(this).parents(".accordion-group");
                    $(".md-accent-bg").removeClass("md-accent-bg");
                    $(this).find(".accordion-group").addClass("md-accent-bg");
                    return;
                }
            })

            this.initDomListener(this.param);
            this.initSelect();

        },


        eventDomRole:function(){
            var me = this;
            /*权限设定*/
            $(".J_purview_set").click(function(){
                var id = $(this).attr('_id')
                $.colorbox({
                    inline:true,href:"#purview_dialog",
                    innerWidth:500,innerHeight:400,title:'权限设定',onOpen:function(){
                        $('.J_sure_purview').attr('_id',id);
                            /*确定 权限*/
                            $('.J_sure_purview').click(function(){
                                $.colorbox.close();
                                jTip("保存成功");
                            });



                    }
                });
            });

            /*删除角色*/
            $(".J_delRole_btn").click(function(){
                var $this = $(this);
                confirmDIV('您确定要删除该角色吗？',function(flag){
                    if(flag){
                        jTip('删除成功');
                        $this.parent('.set_item_role').remove();
                    }
                })


            });
            /*添加角色*/
            $(".J_add_role").colorbox({
                inline:true,href:"#addrole_dialog",
                innerWidth:500,innerHeight:240,title:'添加角色',onComplete:function(){
                    /*确定*/
                    $(".J_sure_roleBtn").click(function(){
                        $.colorbox.close();
                        jTip('添加成功');
                    });
                }
            });
        },
        eventDomAccount:function(){
            var me = this;
            /*添加部门或企业账号*/
            $(".J_add_AccountDia").click(function(){
                if($(this).attr('_box') == 0){
                    alertDIV('您还没有添加角色,暂不能添加账号,请先添加角色!');
                    return;
                }else{
                    $.colorbox({
                        inline:true,href:"#addAccount_dialog",
                        innerWidth:500,initialHeight:240,title:'添加部门或企业账号',onComplete:function(){
                            /*确定*/
                            $(".J_add_account").click(function() {
                                jTip('创建成功');
                                $.colorbox.close()
                            })
                        }
                    });
                }
            });

            /*删除账号*/
            $(".J_delete_account").click(function(){
                var $this = $(this);
                confirmDIV('您确定要删除该账号吗？',function(flag){
                    if(flag){
                        $this.parent('.set_item').remove();
                        jTip('删除成功');
                    }
                })


            });
        },
        eventDomMember:function(){
            var me = this;
            /*删除成员账号*/
            $(".J_delMember_btn").click(function(){
                var $this = $(this);
                    confirmDIV('您确定要删除该成员吗？',function(flag){
                        if(flag){
                            $this.parent('.set_item').remove();
                            jTip('删除成功');
                        }
                    })


            });
            /*邀请团队成员*/
            $(".J_add_member").colorbox({
                inline:true,href:"#addTeam_dialog",
                innerWidth:500,innerHeight:240,title:'邀请团队成员',onComplete:function(){
                    /*确定*/
                    $(".J_addTeam_sure").click(function(){
                        jTip('邀请成功');
                        $.colorbox.close();


                    });
                }
            });
        },
        initDomListener:function(param){
            var me = this;
         
            /*添加账号*/
            me.eventDomAccount();
            /*团队成员*/
            me.eventDomMember();
           /*团队角色*/
            me.eventDomRole();
              /*修改密码*/
            $(".J_password_btn").colorbox({
                inline:true,href:"#changePassword_dialog",
                innerWidth:500,innerHeight:320,title:'修改密码',onComplete:function(){

                }
            });


            /*确定 修改密码*/
            $(".J_sure_pwd").click(function() {
                jTip('修改成功');
                window.location.href = '/'
                $.colorbox.close();
            })
        },
        initSelect: function () {
            new selectControl({
                domId: 'J_roleType', //必填
                options: {'1':'部门1','2':'部门2'},//必填
                width: '100%',//下拉宽度
                isDefaultTitle: false,
                defaultVal: $(this).find(".select-value").val()
            })
        }


    }
    return sw_setting;
})