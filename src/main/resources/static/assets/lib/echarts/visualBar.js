/**
 * Created by Administrator on 2017/5/9.
 */


/*
 功能: 获取配置项
 输入：
    type - 'need' || 'index'
    data - [{name:'上海',value:85},{name:'广州',value:90}]
 */
function getOptionBar(type, data, _title){
    type = type || 'need';
    var title = {'need':"城市分布", 'index':"行业分布"}[type];
    var colorCfg = {'need':[['#3388D5', '#63C3F5'], ['#3388D5', '#9198FF']],
        'index':[['#53D53F', '#D9F96C'], ['#53D53F', '#D9F96C']]};
    var GDC = function(cls){    //颜色梯度转换
        var cg = [{offset: 0, color: cls[0]}, {offset: 1, color: cls[1]},
            {offset: 0, color: cls[0]}, {offset: 1, color: cls[1]}];
        return new echarts.graphic.LinearGradient( 0, 0, 1, 1, cg )
    };

    var color = {'need':[GDC(colorCfg.need[0]), GDC(colorCfg.need[1]), "#3CC9F0"],
        'index':[GDC(colorCfg.index[0]), GDC(colorCfg.index[1]), "#93ED79"]}[type];

    data.sort(function(a, b){ return a.value - b.value; });
    var dt = data.map(function(d){ return d.value; });

    var option = {
        title:{ text:_title, textStyle:{color:"#fff", fontSize:16}, top:"20px", left:"center"},
        tooltip: { trigger: 'item', textStyle:{ fontFamily:"楷体" },
            formatter:function(p){ return p.name + "<br>" + title + "：" + p.data} },
        grid:{left:"100px",},
        xAxis: { type: 'value',  boundaryGap: [0, 0.01], axisLine:{ lineStyle:{ color:'#d3d6db'}, show:false},
            axisLabel:{textStyle:{color:'#fff'}, show:false}, splitLine:{show:false}, axisTick:{show:false}
        },
        yAxis: { type: 'category',  axisLine:{ lineStyle:{ color:'#d3d6db'}, show:false}, axisLabel:{textStyle:{color:'#fff'}},
            data: data.map(function(d){ return d.name; }), splitLine:{show:false}, axisTick:{show:false}
        },
        series: [ { type: 'bar', data: dt, barWidth:16,
            label:{normal:{show:true, position:'right'}},
            itemStyle:{normal:{color:color[0], barBorderRadius:15, shadowColor:"#ccc", borderColor:color[2], borderWidth:2 }, emphasis:{color:color[1] }}
        } ]
    };
    return option;
}

//需求量图
function ShowBarColor1(id, data, title){
    var option = getOptionBar('need', data, title);
    Init3(option, id);
}

//供需指数图
function ShowBarColor2(id, data, title){
    var option = getOptionBar('index', data, title);
    Init3(option, id);
}
