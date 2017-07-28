/**
 * Created by Administrator on 2017/5/4.
 */
define([
    'echarts',
    'echartspublic',
    'echartvisualPie',
    "colorbox"
],function(ec,echartsd3){
    var sw_dashboard = {
        arrDate:[],
        cityobj:{},
        ready:function(){
            echarts = ec;
            d3 = echartsd3;
            this.loadPie();

        },
        loadPie:function(){
            var data = {data:{"ageCount":[{"name":"30-40岁","value":14},{"name":"25-30岁","value":22},{"name":"25岁以下","value":8},{"name":"40岁以上","value":1}],"genderCount":[{"name":"女","value":3637},{"name":"男","value":17153}],"degreeCount":[{"name":"大专及以下","value":12},{"name":"本科","value":30},{"name":"博士及以上","value":15230},{"name":"研究生","value":31}],"cityCount":[{"name":"成都","value":36},{"name":"上海","value":3},{"name":"广州","value":1},{"name":"北京","value":1},{"name":"福州","value":1},{"name":"深圳","value":1},{"name":"长沙","value":1},{"name":"绍兴","value":1},{"name":"其他","value":0}]}}
            ShowPieEx("view1", data.data.genderCount, "性别");
            ShowPieEx("view2", data.data.ageCount, "年龄");
            ShowPieEx("view3", data.data.degreeCount, "学历");
            ShowPieEx("view4", data.data.cityCount, "城市");

        },
        initData:function(){
            $.post('/summaryData',{source:$.cookie(location.host + "_sou")},function(res){
                if(res.code == 0){
                    $('.A_talentIncrement').text(res.data.talentIncrement);
                    $('.A_talentTotal').text(res.data.talentTotal);
                    $('.A_postionServiceCount').text(res.data.postionServiceCount);
                    $('.A_memberAmount').text(res.data.memberAmount);
                }else{
                    alertDIV(res.msg);
                }

            });
        }
    }
    return sw_dashboard;
})