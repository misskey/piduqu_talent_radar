
var require = {
    urlArgs:"v="+new Date().getTime() ,
    paths: {
        css:"assets/lib/require/css",
        text:"assets/lib/require/require.text",
        jquery: 'assets/lib/jquery.min',

        bootstrap:"assets/lib/bootstrap/js/bootstrap.min",
        listener:"assets/lib/listener",
        util:"assets/lib/util",
        validator:"assets/lib/validator",
        msg:"assets/lib/msg",
        beanUtil:"assets/lib/beanUtil",
        prototype:"assets/lib/prototype",
        dic:"assets/lib/dic",
        alertdialog:"assets/lib/jqueryalert/jquery.alerts",
        multilevelpicker : 'assets/lib/multilevelpicker/multilevelpicker',
        mCustomScrollbar:"assets/lib/mCustomScrollbar/jquery.mCustomScrollbar.min",
        mousewheel:"assets/lib/mCustomScrollbar/jquery.mousewheel-3.0.6.min",
        datetimepicker:"assets/lib/bo/bootstrap-datetimepicker.min",
        datetimepickerZh:"assets/lib/bo/bootstrap-datetimepicker.zh-CN",

        colorbox:"assets/lib/colorbox/jquery.colorbox",
        selectControl:"assets/lib/select/select",
        selectAll:"assets/lib/jquery.selectAll",
        /*echarts*/
        echarts:"assets/lib/echarts/echarts.v3.min",
        echartspublic:"assets/lib/echarts/public",
        echartvisualPie:"assets/lib/echarts/visualPie",


        common:"assets/lib/common",
        dashboard:"assets/dashboard",
        talentList:"assets/talentList",
        setting:"assets/setting",
        inputResume:"assets/inputResume"



    },
    shim: {
        'bootstrap':['jquery'],
        'colorbox':{
            deps: ['jquery','css!assets/lib/colorbox/colorbox.css']
        },
        "selectAll":["jquery"],

        "alertdialog":{
            deps: ['jquery','css!assets/lib/jqueryalert/jquery.alerts.css']
        },
        "selectControl":{
            deps: ['jquery','css!assets/lib/select/css/select.css']
        },
        "datetimepicker":{
            deps: ['jquery','css!assets/lib/bo/bootstrap-datetimepicker.min.css']
        },

        mCustomScrollbar:{
            exports:'mCustomScrollbar',
            deps:["jquery","mousewheel","css!assets/lib/mCustomScrollbar/jquery.mCustomScrollbar.css"]
        }

    },
    waitSeconds: 0
};