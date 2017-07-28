/**
 * Created by Administrator on 2017/5/8.
 */


function ltIE9(){
    var browser=navigator.appName
    var b_version=navigator.appVersion
    var version=b_version.split(";");
    var trim_Version=version[1].replace(/[ ]/g,"");
    if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE6.0")
    {
        return true;
    }
    else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE7.0")
    {
        return true;
    }
    else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE8.0")
    {
        return true;
    }
    else if(browser=="Microsoft Internet Explorer" && trim_Version=="MSIE9.0")
    {
        return false;
    }
    return false;
}




//仿照bootstrap，分12格
function SplitDiv(id, cols){
    cout(cols);
    var main = document.getElementById(id), txt = "", ids = [], width = main.offsetWidth, height = main.offsetHeight;
    cols.forEach(function(d, i){
        var w = parseInt(1.0 * width / 12 * d)  - 1, cid = id + "_c" + i;
        txt += "<div id='" + cid + "' style='float:left;height:" + height + "px; width:" + w + "px'></div>";
        ids.push(cid);
    });
    main.innerHTML = txt;

    //尺寸自适应
    $(window).resize(function(){
        var width = document.getElementById(id).offsetWidth;
        ids.forEach(function(d, i){
            var w = parseInt(1.0 * width / 12 * cols[i])  - 1;
            $("#"+d).width(w);
        });
        $("#"+id).find("div").each(function(i, d){
            if($(d).attr("_echarts_instance_")==undefined)return;
            var e = echarts.getInstanceByDom($(d)[0]);
            e.resize();
            cout($(d)[0]);
        });
    });

    return ids;
}


//增加一个头部div
function AddDivHead(id, height){
    height = height || 30;
    var main = document.getElementById(id), H = main.offsetHeight;
    var headId = id + '_head', bodyId = id + '_body';
    var txt = "<div id='"+ headId +"' style='width: 100%; height:" + height + "px'></div>";
    txt += "<div id='"+ bodyId +"' style='width: 100%; height:" + (H - height) + "px'></div>";
    main.innerHTML = txt;
    return {"headId":headId, "bodyId":bodyId};
}

function Init(option, id, eventName, callback, otherLibs){
    id=id || "main";
    var libs = ['echarts','echarts/chart/line','echarts/chart/bar','echarts/chart/pie','echarts/chart/scatter',
        'echarts/chart/lines','echarts/chart/map'];
    if(otherLibs != null)otherLibs.forEach(function(d){ libs.push('echarts/chart/' + d) });
    require(libs,
        function (ec) {
            var myChart = ec.init(document.getElementById(id));
            if(eventName != null)myChart.on(eventName, callback);
            myChart.setOption(option);
            window.onresize = myChart.resize;
        }
    )
}

function set(){this.data={};this.keys=[];this.add=function(e){if(!this.data.hasOwnProperty(e))this.keys.push(e);this.data[e]=1;};}
function cout(obj){ console.log(obj); }


function Init3(option, id){
    var myChart = echarts.init(document.getElementById(id), 'dark');
    myChart.setOption(option);
    myChart.hideLoading();
    return myChart;
}






