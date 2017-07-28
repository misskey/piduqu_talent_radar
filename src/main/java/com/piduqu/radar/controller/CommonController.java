package com.piduqu.radar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String inputResume(){
        return "inputResume";
    }

    @RequestMapping("setting")
    public String setting(){
        return "setting";
    }
}
