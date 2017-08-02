package com.piduqu.radar.controller;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.service.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by liu_zhangyun on 2017/7/27.
 * Cell:15884457479
 * Email:zhangyun.liu@hirebigdata.cn
 * Description:
 * <p/>
 * Functions:
 * 1.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private IMessageService iMessageService;

    @RequestMapping("/sendMsg")
    @ResponseBody
    public JsonResult sendMsg(@Valid String msg){

        return iMessageService.sendMsg(msg);
    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public JsonResult sendEmail(@Valid String subject,String data){
        //TODO 发送邮件

        return iMessageService.sendMsg(data);
    }
}
