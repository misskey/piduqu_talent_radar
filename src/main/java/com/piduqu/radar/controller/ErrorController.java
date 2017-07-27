package com.piduqu.radar.controller;

import com.piduqu.radar.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 无聊的挂面
 * @since 2017-07-18 17:06
 */
@Controller
public class ErrorController extends BaseController {

    @RequestMapping("/previlige/no")
    @ResponseBody
    public JsonResult userDelete(ModelMap model){
        return JsonResult.failure("无权限");
    }
}
