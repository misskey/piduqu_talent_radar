/**
 * Created by Administrator on 2017/5/5.
 */
define([
    'selectControl',
    'colorbox',
    'selectAll'
], function ( selectControl, listDialog) {
    var sw_talentList = {
        selectMap: {},
        arr: [],
        nPage: 1,
        detail:2,
        pid:'',
        industry : [],
        inland_level:[],
        date_updated:'',
         ready: function () {

             this.initDomListener();
            this.sendMessageClick();
             this.eventDom();
        },
        initDomListener: function () {
            var me = this;
            /*筛选*/
            $(".J_filter_btn").click(function () {
                $(".ss-model").slideToggle();
            });

            /*取消筛选*/
            $(".J_cancel").click(function () {
                $(".filter-model cite").removeClass('checked');
                $(".filter-model").removeClass('open');
            });
            /*确定筛选*/
            $(".J_sure_filtrate").click(function(){
             alertDIV('后期进行筛选');

            });
            $(".J_download_resume").click(function(){
                jTip('下载成功');
            })

        },
        sendMessageClick: function () {
            var me = this;
            /*发送消息*/
            $(".J_sendMsg_btn").click(function () {

                if ($(this).attr('_source') == 1) {
                    me.sendMessage('1');
                } else {
                    if ($(".select_child.checked").length != 0) {
                        me.sendMessage('0');
                    } else {
                        alertDIV('请勾选人才！');
                    }
                }


            });

        },
        sendMessage: function (yp) {
            var checkArr = [];
            $.colorbox({
                inline: true, href: "#sendMsg_dialog",
                innerWidth: 500, innerHeight: 400, title: '发送消息', onComplete: function () {
                    if (yp == 1) {

                        $(".A_sendName").empty().append('<span class="send-mark mb10 sendmsg"  title=" xxxx">xxxx</span>');
   /*                     checkArr.push($('.G_name').attr('_id'));*/
                    } else {
                        var str = '';
                                str += '<span class="send-mark mb10 sendmsg">xxxx<i class="icon icon-delete cur J_delete_sendPerson"></i></span>';
                        $(".A_sendName").empty().append(str)
                    }
                    /*删除 发送消息*/
                    $(".J_delete_sendPerson").click(function () {
                        $(this).parent('.sendmsg').remove();
                    })
                }
            });
            /*确定发送消息*/
            $('.J_sendMessage_sure').click(function () {
                jTip('发送成功！');
                $.colorbox.close();

            });

        },
        eventDom: function (pageArr,type,pid) {
            var me =this;
            var $select_all = $('#select_all');
            $select_all.allSelect({
                attr: '_value',
                selectLengthClass: 'J_select_resume'
            });

            /*详情*/
            $(".J_open_talentDetail").off().on('click', function (e) {


                if($(event.target).hasClass('pay-check')){
                    return;
                }

                me.talentDetail();
            });
        },
        talentDetail: function () {
            var me = this;
                    $('#viewOverlay').remove();
                    $("body").append('<div id="viewOverlay"></div>');
                    $(".view_TalentDetail").fadeIn();
                    me.sendMessageClick();

            /*关闭*/
            $(document).on('click.J_close_view', '.J_close_view', function (e) {
                $(".view_TalentDetail").fadeOut(function () {
                    $("body #viewOverlay").remove().css('overflow', 'auto');
                });

            });

        }


    }
    return sw_talentList;
})