require(['jquery', 'listener','util','bootstrap',
    'alertdialog'],function($, sw_listener,util){
    sw_listener.initDefaultListener();
    sw_util = util;
    htmlEncode = sw_util.htmlEncode;
    htmlTitleEncode = sw_util.htmlTitleEncode;
    htmlDecode = sw_util.htmlDecode;

    alertDIV = sw_util.alertDIV;
    confirmDIV = sw_util.confirmDIV;
    tipsDIV = sw_util.tipsDIV;
});

