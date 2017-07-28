/**
 * Created by simon on 2017/5/8.

 依赖：
 china.js            //中国地图
 world.js            //世界地图
 citys.js            //城市坐标
 echarts.v3.min.js   //图形库
 public.js           //Init3()
 d3.v3.min.js        //d3绘图引擎
 dragTool.js         //addDragTool()

 */

/*----------------------------------地图核心程序----------------------------------*/
/*
 描述：整合 人才流动 和 人才分布 图功能
 人才流动：getOptionMap("flowOut") 或 showMapFlow()
 人才分布：getOptionMap("top") 或 showMapTop()
 职能分布：getOptionMap("region")     - 配合饼图，区域放大
 输出图配置项或直接绘图
 输入：
 id - 图形容器div, string
 data - 数据, array with object
 example: [{name:'上海',value:85},{name:'广州',value:90}]
 flowD - 流动方向， 'flowOut' || 'flowIn'
 cCity - 中心城市, string
 调用：
 var map = new MapGeo(id, data);
 map.showMapFlow();
 map.showMapTop();
 依赖：
 china.js            //中国地图
 citys.js            //城市坐标
 echarts.v3.min.js   //图形库
 public.js           //Init3()
 d3.v4.min.js        //d3绘图引擎
 dragTool.js         //addDragTool()
 */


function MapFlow(id, dt, flowD, city){
    this.flowD =  flowD || "flowOut";
    this.city = city || "成都";
    var flowPath = 'path://M5,1 L8,10 L5,6 L2,10 L5,2';
    var citys = {};
    var $this = this;

    var color = ["#C6416F", "#B6F1F1", "#EC9682", "#38DA41", "#E62155", "#1C5995"] ; //#C2D840
    var allData = {"points":[], "lines":[]}, maxV = dt[0].value, maxR = 15;
    dt = dt.sort(function(a, b){ return a.value - b.value; });

    function mulitFlow(dt){ return dt.length>0 && ('fromName' in dt[0]); }
    function colorS(i){ return i > 9 ? color[5] : color[parseInt(i/2)]; }
    function sizeS(d, i){ return i > 9 ? 2 : parseInt(1.0 * d / maxV * maxR); }

    //数据规范化，添加经纬度信息
    this.convertData = function (dt) {
        dt.forEach(function(d, i){
            var fromCoord = getCityPosEx(d.fromName), toCoord = getCityPosEx(d.toName);
            var line = { fromName: d.fromName, toName: d.toName, value: d.value, coords: [fromCoord, toCoord]};
            line['lineStyle'] = {"normal":{"color":colorS(i) }};

            var pCoord = $this.flowD==="flowOut" ? toCoord : fromCoord;
            var point = {"value":pCoord.concat([d.value]), "symbolSize":sizeS(d.value, i) };
            point['name'] = $this.flowD==="flowOut" ? d.toName : d.fromName;
            point['itemStyle'] = {"normal":{"color":colorS(i) }};

            if (!(fromCoord && toCoord))return;
            allData["lines"].push(line);
            allData["points"].push(point);
        });

        //流动中心点亮
        if(!(city in citys)){
            var value = parseInt(maxV / 2);
            allData["points"].push({"name":$this.city, "value":getCityPosEx($this.city).concat([value]),
                "symbolSize":sizeS(value, 0) });
        }
    };

    //兼容多源和单源流动， 默认成都、流出
    this.formatData = function (dt, city, fd){
        if(mulitFlow(dt))return dt;
        city = city || $this.city;
        fd = fd || $this.flowD;
        return dt.map(function(d){
            var line = fd==="flowOut" ? { fromName: city, toName: d.name} : { fromName: d.name, toName: city };
            line['value'] = d.value;
            citys[d.name] = d.value;
            return line;
        });
    };

    //主要option
    this.getOption = function(){
        var option = {
            backgroundColor: '#192636',
            title: { text: '成都市人才流动图', left: 'center', top:"70px", textStyle: { color: '#fff', fontSize:16} },
            tooltip: { trigger: 'item', formatter:function(p){
                if(p.componentSubType!="effectScatter")return;  //暂时不做线条提示
                return p.name + "<br>人数：" + p.data.value[2] + " "; }
            },
            legend: {
                show: false, top: 'bottom', left: 'right',
                data: ['流入', '流出'], textStyle: { color: '#fff' }
            },
            geo: {
                map: 'china', zoom:1.1, roam: true, label: { emphasis: { show: false } },
                itemStyle: {
                    normal: { areaColor: '#253E5A', borderColor: '#355E8C', borderWidth:1 },
                    emphasis: { areaColor: '#2a333d' }
                }
            },
            series: [{
                name: "流入", type: 'lines', zlevel: 1,
                effect: { show: true, period: 5, trailLength: 0.7, symbolSize: 2 },
                lineStyle: { normal: { width: 0, curveness: 0.2 } },
                data: allData.lines
            }, {
                name: '流入', type: 'lines', coordinateSystem: 'geo', zlevel: 2, large: true,
                effect: { show: true, period: 5, symbolSize: 6, trailLength: 0, symbol: flowPath },
                lineStyle: { normal: { width: 1, opacity: 0.65, curveness: 0.2 } },
                data: allData.lines
            }, {
                name:"流入", type: 'effectScatter', coordinateSystem: 'geo', zlevel: 2,
                rippleEffect: { period: 4, scale: 2.5, brushType: 'stroke'},
                label: { normal: { show: true, position: 'right',
                    formatter: function(d){
                        //if(d.name==$this.city)return d.name;  return d.value[2];
                        return d.name + "(" + d.value[2] + ")";
                    }
                }},
                symbolSize: 5,
                itemStyle: { normal: { color: '#D84F2C' } },
                data: allData.points
            }]
        };
        return option;
    };

    this.convertData(this.formatData(dt));
    var option = this.getOption();
    this.Draw = function(){ Init3(option, id); };

    this.Draw();
    this.Demo = function(){};

}

var MF = MapFlow;
//-------------------------------End Class Map--------------------------------------------------------

//封装人才流动页面所有功能
function ShowMapFlow(id, callbackOut, callbackIn ){
    var ids = SplitDiv(id, [8, 4]), lids = AddDivHead(ids[0], 60);;
    var leftDiv = ids[0], centerDiv = ids[1];//, rightDiv = ids[2];    //主要三图div
    var leftHead = lids.headId, leftBody = lids.bodyId;             //左图首部和主要div

    //默认加载流出图
    var __loadOut = function (data){
        ShowMapFlowOut(leftBody, data);
        ShowBarColor1(centerDiv, data, "城市分布");
        //ShowBarColor2(rightDiv, data, "行业分布");
    };

    var __loadIn = function (data){
        ShowMapFlowIn(leftBody, data);
        ShowBarColor1(centerDiv, data, "城市分布");
        //ShowBarColor2(rightDiv, data, "行业分布");
    };

    addButton(leftHead, callbackOut, callbackIn, __loadOut, __loadIn);
    callbackOut(__loadOut);
}


function ShowMapFlowOut(id, data){
    var mf = new MapFlow(id, data, "flowOut", "成都");

}

function ShowMapFlowIn(id, data){
    var mf = new MapFlow(id, data, "flowIn", "成都");

}

//*******************增加流入流出按钮*******************
function addButton(id, callback1, callback2, loadOut, loadIn){
    var div = document.getElementById(id);
    div.style.textAlign = "center";
    var style = "border:0px;height:26px;width:60px;background-color: #404A5A; cursor: pointer; color:#fff; bottom:0px; margin-top:30px";
    var txt = "<button class='flowBtn' id='" + id + "Out' style='"+ style +";background-color: #E52255'>流出</button>";
    txt += "<button class='flowBtn'  id='" + id + "In' style='"+ style +"'>流入</button>";
    div.innerHTML = txt;
    function clk(obj){
        var btns = document.getElementsByClassName("flowBtn");
        for (var i = 0; i < btns.length; i++)btns[i].style.backgroundColor = "#404A5A";
        obj.style.backgroundColor = "#E52255";
    }
    document.getElementById(id + "Out").onclick = function(){ clk(this); if(callback1)callback1(loadOut); }
    document.getElementById(id + "In").onclick = function(){ clk(this); if(callback2)callback2(loadIn); }
}





//人才分布功能主要代码
//----------------------------------------------------------------------------------------------------------------------

function ShowMapRegion(id, callbackAdd, callbackReduce){
    var obj = document.getElementById(id), viewId = id + "View";;
    obj.style.backgroundColor = "#404A59";
    obj.style.position = "relative";
    obj.innerHTML = "<div id='" + viewId + "' style='width:100%; height: 100%;background-color: #404A59'></div>"
    //var ids = AddDivHead(id, 60);
    //var leftHead = ids.headId, leftBody = ids.bodyId;
    var leftBody = viewId;
    var graph = null, level = 0;

    var __loadWorld = function(data){
        graph = MapRegionWorld(leftBody, data, callbackAdd, __loadChina);
        level = 0;
    };
    var __loadChina = function(data){
        if(level>0)return;
        //MapRegionChina(leftBody, data);
        MapRegionChinaEx(graph, data);
        cout(level);
        level = 1;
    };

    this.scaleTool = AddScaleTool(id, callbackAdd, callbackReduce, 1, __loadChina, __loadWorld);
    callbackReduce(__loadWorld);
}

function MapRegionWorld(id, data, callbackClick, __funcClick){
    "use strict";
    var nameMap = getCountrys();
    var maxV = data.reduce(function(a, b){ return a>b.value ? a : b.value; }, 0);

    var getOption = function(){
        var option = {
            title:{ text:"世界各国人才分布", textStyle:{color:"#fff"}, left:"150px", top:"8px"},
            backgroundColor: '#404A59',
            tooltip: { trigger: 'item' },
            visualMap: [{
                max: maxV, calculable: true, textStyle:{color:"#fff"},
                inRange: {
                    color: ['#3682da', '#6faaee']   //, '#ff9966', '#ff6666', '#ff3366', '#ff0066']
                }
            }],
            series: [{
                type: 'map', map: 'world', data: data, nameMap: nameMap,
                itemStyle: {
                    normal: { areaColor: '#D1EEEE', borderColor: '#355E8C', borderWidth:1 }, emphasis: { areaColor: '#FDBA7E' }
                }
            }]
        };
        return option;
    };

    var option = getOption();
    var e = Init3(option, id);
    e.on("click", function(d){
        if(d.seriesType=="map" && d.name=="中国")callbackClick(__funcClick, d.name);
    });
    return e;
}

function MapRegionChinaEx(graph, data){
    var serie = {
        type: 'map', mapType: 'china', roam: false, data: data, zlevel:2, zoom:1.2,
        label: { normal: { show: true }, emphasis: { show: true } },
        itemStyle: {
            normal: { areaColor: '#D1EEEE', borderColor: '#355E8C', borderWidth:1 }, emphasis: { areaColor: '#FDBA7E' }
        }
    };
    var maxV = data.reduce(function(a, b){ return a>b.value ? a : b.value; }, 0);
    var option = graph.getOption();
    option.title[0].text = "中国人才分布";
    option.series[0].zoom = 4.7;
    option.series[0].center = [104.33, 35.80];
    option.visualMap[0].show = false;
    option.visualMap.push({
        max: maxV, calculable: true, textStyle:{color:"#fff"}, //min: 0, max: maxV,
        inRange: {
            color: ['#3682da', '#6faaee']
        }
    });

    //cout(option.series[0]);
    //cout(data);

    option.series.push(serie);
    graph.setOption(option);
}

//中国地图区域分布
function MapRegionChina(id, data){
    "use strict";
    var maxV = data.reduce(function(a, b){ return a>b.value ? a : b.value; }, 0);

    var getOption = function(){
        var option = {
            backgroundColor: '#404A59',
            title: { text: '', subtext: '', left: 'center' },
            tooltip: { trigger: 'item' },
            visualMap: {
                min: 0, max: maxV, textStyle:{color:"#fff"}, calculable: true, // 文本，默认为数值文本
            },
            series: [
                {
                    type: 'map', mapType: 'china', roam: false, data: data, zlevel:1,
                label: { normal: { show: true }, emphasis: { show: true } },
                    itemStyle: {
                        normal: { areaColor: '#D1EEEE', borderColor: '#355E8C', borderWidth:1 }, emphasis: { areaColor: '#FDBA7E' }
                    }
                }
            ]
        };
        return option;
    };

    var option = getOption();
    Init3(option, id);
}


//封装人才流动页面所有功能
//---------------------------------------------------------------------
function ShowChengdu(id, callbackAll, callbackClick) {
    var ids = SplitDiv(id, [6, 3, 3]);
    var leftDiv = ids[0], centerDiv = ids[1], rightDiv = ids[2];    //主要三图div

    var __loadClick = function(data1, data2){
        ShowBarColor1(centerDiv, data1, "城市分布");
        ShowBarColor2(rightDiv, data2, "行业分布");
    };

    var __loadAll = function(data1, data2, data3){
        MapRegionChengdu(leftDiv, data1, callbackClick, __loadClick);
        ShowBarColor1(centerDiv, data2, "城市分布");
        ShowBarColor2(rightDiv, data3, "行业分布");
    };

    callbackAll(__loadAll);




}

//成都地图区域分布
function MapRegionChengdu(id, data, callbackClick, __funcClick) {
    "use strict";
    var dataCache = data.reduce(function(a, b){ a[b.name]= b.value; return a;}, {});
    var getOption = function(){
        var option = {
            backgroundColor: '#192636',
            title: { text: '成都市区域分布', top: '20px', left: '20px',textStyle:{fontSize:14, color:"#fff"} },
            visualMap: {
                seriesIndex: 0, min: 0, max: 100, show:false, calculable: true, inRange: {color: ['#253E5A', '#253E5A']}
            },
            tooltip: { trigger: 'item', textStyle:{color:"#fff"},
                formatter:function(d){ return d.name + "<br>" + ((d.name in dataCache) ? dataCache[d.name] : "暂无数据");}
            },
            series: [{
                type:'map', map: '成都', data: data, top: '38%', roam: false, //right: '35%',
                center: [104.07, 30.68], zoom: 55,  //成都地图比较怪异，需要手动调大小和位置
                label: { normal: { show: true, textStyle:{color:"#3997BE"} }, emphasis: { show: true, textStyle:{color:"#fff"} } },
                itemStyle: {normal: { areaColor: '#253E5A', borderColor: '#386DA8' },
                    emphasis: { areaColor: '#132B45', borderWidth:2 }
                },
            }]
        };
        return option;
    };
    var option = getOption();
    var e = Init3(option, id);
    e.on("click", function(d){ if(d.seriesType=="map" && d.name!="" && d.name!=undefined )callbackClick(__funcClick, d.name)});
}


/* -------------------------------------------------放大缩小小公举------------------------------------------------------- */
//For IE8
function ScaleToolIE8(id, callbackAdd, callbackReduce, scale, __funcAdd, __funcReduce){
    "use strict";
    console.log(id + "IE");
    var $this = this;
    this.parentId = id;
    this.scale = scale || 1;     //当前缩放尺寸
    var canvas = document.createElement('canvas');
    canvas.id = id + "ScaleTool";
    canvas.style.position = "absolute";
    canvas.style.left = "0px";
    canvas.style.top = "20px";
    document.getElementById(id).appendChild(canvas);
    canvas = window.G_vmlCanvasManager.initElement(canvas);
    var context = canvas.getContext("2d");

    var color = {"out":"#88898B", "inside":"#9A9A9A", "over":"#1E90FF", "fill":"#FAFCFF" },
        cfg = {x:50, y:50, width:25, height:25, dis:8, padding:5 }, c = cfg;
    var rectOut = [[c.x, c.y, c.width, c.height], [c.x + c.width + c.dis, c.y, c.width, c.height]],
        rectIn = [[{x:c.x + c.padding, y: c.y + c.height/2}, {x:c.x + c.width - c.padding, y:c.y + c.height/2}],
            [{x:c.x + c.width / 2, y: c.y + c.padding}, {x:c.x + c.width / 2, y:c.y + c.height - c.padding}],
            [{x:rectOut[1][0] + c.padding, y: c.y + c.height/2}, {x:rectOut[1][0] + c.width - c.padding, y:c.y + c.height/2}],
    ];
    //
    rectOut.forEach(function(d){
        drawRectOutP(d, color.fill);
    });
    rectIn.forEach(function(d){
        drawRectInP(d, color.inside);
    });

    // 绘外围
    function drawRectOutP(d, clr){
        context.lineWidth = 2;
        context.fillStyle = clr;
        context.strokeStyle = color.out;
        context.strokeRect(d[0], d[1], d[2], d[3]);
        context.fillRect(d[0], d[1], d[2], d[3]);
    }
    // 绘里边
    function drawRectInP(d, clr){
        context.beginPath();
        context.moveTo(d[0].x, d[0].y);
        context.lineTo(d[1].x, d[1].y);
        context.lineWidth = 1;
        context.strokeStyle = clr;
        context.stroke();
    }

    function isInAdd(x, y){
        return (x > c.x && y > c.y && x < (c.x + c.width) && y < (c.y + c.height));
    }
    function isInReduce(x, y){
        return (x > rectOut[1][0] && y > rectOut[1][1] && x < (rectOut[1][0] + c.width) && y < (rectOut[1][1] + c.height));
    }

    canvas.onmousemove = function(){
        var evt = event;
        var left = canvas.getBoundingClientRect().left, top = canvas.getBoundingClientRect().top;
        var x = evt.clientX - left, y = evt.clientY - top;
        var add  = isInAdd(x, y), reduce = isInReduce(x, y);
        if(!(add || reduce)){
            drawRectInP(rectIn[0], color.inside);
            drawRectInP(rectIn[1], color.inside);
            drawRectInP(rectIn[2], color.inside);
            canvas.style.cursor = "default";
            return;
        }
        if(add){
            drawRectInP(rectIn[0], color.over);
            drawRectInP(rectIn[1], color.over);
        }
        if(reduce) drawRectInP(rectIn[2], color.over);
        canvas.style.cursor = "pointer";
    };

    canvas.onclick = function() {
        var evt = event;
        var left = canvas.getBoundingClientRect().left, top = canvas.getBoundingClientRect().top;
        var x = evt.clientX - left, y = evt.clientY - top;
        if(isInAdd(x, y) && callbackAdd!=undefined){
            $this.scale++;
            callbackAdd(__funcAdd, $this.scale);
        }
        if(isInReduce(x, y) && callbackReduce!=undefined){
            $this.scale--;
            callbackReduce(__funcReduce, $this.scale);
        }
    };
}
// -- End Class --

function ScaleTool(id, callbackAdd, callbackReduce, scale, __funcAdd, __funcReduce){
    "use strict";
    var $this = this;
    this.parentId = id;
    this.scale = scale || 1;     //当前缩放尺寸
    if("undefined" === typeof d3){
        console.error("d3js library required!");
        return;
    }
    var svg = d3.select("#" + $this.parentId).append("svg").style("z-index", 999)
        .attr("width", 150).attr("height", 50).style("position", "absolute").style("top", "60px");  //absolute
    this.svg = svg;

    var pathOut = "M5,5v25h25V5H5", pathAdd = "M10,17.5H25M17.5,10V25", pathReduce = "M11,17.5H24";
    // 注： path : [d, width, color, translate-x, translate-y, class]
    var color = {"out":"#000", "inside":"#9A9A9A", "over":"#1E90FF"};
    var paths = [[pathOut, 0.9, color.out, 50, 0, "path1"], [pathAdd, 2, color.inside, 50, 0, "path2"],
        [pathOut, 0.9, color.out, 80, 0, "path3"], [pathReduce, 2, color.inside, 80, 0, "path4"]];
    var target = {"path1":".path2", "path3":".path4"};  //mouse event

    var line = svg.append("g").selectAll("path").data(paths).enter().append("path")
        .attr("d", function(d){ return d[0]; })
        .attr("stroke-width", function(d){ return d[1]; })
        .attr("stroke", function(d){ return d[2]; })
        .attr("transform", function(d){ return "translate(" + d[3] + "," + d[4] + ")"; })
        .attr("class", function(d){ return d[5]; })
        .attr("fill", "#FAFCFF")
        .style("cursor", "pointer")
        .on("mouseover", mouseOver)
        .on("mouseout", mouseOut)
        .on("click", clickScale);

    function mouseOver(d){ d3.select(target[d[5]]).attr("stroke", color.over); }
    function mouseOut(d){
        if(d[5] in target)d3.select(target[d[5]]).attr("stroke", color.inside);
    }
    function clickScale(d){
        if((d[5]=="path1" || d[5]=="path2") && callbackAdd!=undefined){
            $this.scale++;
            callbackAdd(__funcAdd, $this.scale);
        }
        if((d[5]=="path3" || d[5]=="path4") && callbackReduce!=undefined){
            $this.scale--;
            callbackReduce(__funcReduce, $this.scale);
        }
        //cout($this.scale);
    }
}



function AddScaleTool(id, callbackA, callbackR, scale, __funcAdd, __funcReduce){
    if (ltIE9()){  // IE浏览器9以下
        return new ScaleToolIE8(id, callbackA, callbackR, scale, __funcAdd, __funcReduce);
    }else{  // 主流
        cout("normal");
        return new ScaleTool(id, callbackA, callbackR, scale, __funcAdd, __funcReduce);
    }
}

function AddScaleToolIE8(id, callbackA, callbackR, scale, __funcAdd, __funcReduce){
    return new ScaleToolIE8(id, callbackA, callbackR, scale, __funcAdd, __funcReduce);
}
//-----------------------End Class----------------------------------------


