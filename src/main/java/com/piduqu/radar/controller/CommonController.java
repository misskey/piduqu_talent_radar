package com.piduqu.radar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by Administrator on 2017/7/27.
 */
@Controller
public class CommonController extends BaseController {
    @RequestMapping("dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @RequestMapping("inputResume")
    public String inputResume(ModelMap model){

        Comparator comparator = Collator.getInstance(Locale.CHINA);


//        String[] contries = {};

        String[] china = {"中国大陆","中国台湾","中国香港","中国澳门"};
        String[] subcontries = {"蒙古","朝鲜","韩国","日本",
                "菲律宾","越南","老挝","柬埔寨","缅甸","泰国","马来西亚","文莱","新加坡","印度尼西亚", "东帝汶",
                "尼泊尔","不丹","孟加拉国","印度","巴基斯坦","斯里兰卡","马尔代夫",
                "哈萨克斯坦","吉尔吉斯斯坦","塔吉克斯坦","乌兹别克斯坦","土库曼斯坦",
                "阿富汗","伊拉克","伊朗","叙利亚","约旦","黎巴嫩","以色列","巴勒斯坦","沙特阿拉伯","巴林","卡塔尔","科威特","阿拉伯联合酋长国（阿联酋）","阿曼","也门","格鲁吉亚","亚美尼亚","阿塞拜疆","土耳其","塞浦路斯",
                "爱沙尼亚","拉脱维亚","立陶宛","白俄罗斯","俄罗斯","乌克兰","摩尔多瓦",
                "波兰","捷克","斯洛伐克","匈牙利","德国","奥地利","瑞士","列支敦士登",
                "英国","爱尔兰","荷兰","比利时","卢森堡","法国","摩纳哥",
                "罗马尼亚","保加利亚","塞尔维亚","马其顿","阿尔巴尼亚","希腊","斯洛文尼亚","克罗地亚","波斯尼亚和墨塞哥维那","意大利","梵蒂冈","圣马力诺","马耳他","西班牙","葡萄牙",
                "安道尔",
                "埃及","利比亚","苏丹","突尼斯","阿尔及利亚","摩洛哥","亚速尔群岛（葡）","马德拉群岛（葡）",
                "埃塞俄比亚","厄立特里亚","索马里","吉布提","肯尼亚","坦桑尼亚","乌干达","卢旺达","布隆迪","塞舌尔",
                "乍得","中非","喀麦隆","赤道几内亚","加蓬","刚果共和国","刚果民主共和国",
                "毛里塔尼亚","西撒哈拉","塞内加尔","冈比亚","马里","布基纳法索","几内亚","几内亚比绍","佛得角","塞拉利昂","利比里亚","科特迪瓦",
                "加纳","多哥","贝宁","尼日尔","加那利群岛（西）",
                "赞比亚","安哥拉","津巴布韦","马拉维","莫桑比克","博茨瓦纳","纳米比亚","南非","斯威士兰","莱索托","马达加斯加","科摩罗","毛里求斯",
                "留尼旺（法）","圣赫勒拿（英）",
                "澳大利亚","新西兰","巴布亚新几内亚","所罗门群岛","瓦努阿图","密克罗尼西亚","马绍尔群岛","帕劳,瑙鲁","基里巴斯",
                "图瓦卢","萨摩亚","斐济群岛","汤加","库克群岛（新）","关岛（美）","新喀里多尼亚（法）","法属波利尼西亚","皮特凯恩岛（英）","瓦利斯与富图纳（法）",
                "纽埃（新）","托克劳（新）","美属萨摩亚","北马里亚纳（美）","加拿大","美国","墨西哥","格陵兰（丹）",
                "危地马拉","伯利兹","萨尔瓦多","洪都拉斯","尼加拉瓜","哥斯达黎加","巴拿马",
                "巴哈马","古巴","牙买加","海地","多米尼加共和国","安提瓜和巴布达","圣基茨和尼维斯","多米尼克","圣卢西亚",
                "圣文森特和格林纳丁斯","格林纳达","巴巴多斯","特立尼达和多巴哥","波多黎各（美）","英属维尔京群岛",
                "美属维尔京群岛","安圭拉（英）","蒙特塞拉特（英）","瓜德罗普（法）","马提尼克（法）","荷属安的列斯","阿鲁巴（荷）",
                "特克斯和凯科斯群岛（英）","开曼群岛（英）","百慕大（英）",
                "哥伦比亚","委内瑞拉","圭亚那","法属圭亚那","苏里南","厄瓜多尔","秘鲁","玻利维亚","巴西","智利","阿根廷","乌拉圭","巴拉圭"
        };
        Arrays.sort(subcontries, comparator);

        String[] contries = new String[218];
//        for (String s:contries){
            System.out.println(subcontries.length);
//        }
        System.arraycopy(china,0,contries,0,china.length);
        System.arraycopy(subcontries,0,contries,china.length,subcontries.length);
        model.put("nationList",contries);
        return "inputResume";
//        return "inputResume";
    }

    @RequestMapping("setting")
    public String setting(){
        return "setting";
    }
}
