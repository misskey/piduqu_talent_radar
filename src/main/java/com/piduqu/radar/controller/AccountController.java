package com.piduqu.radar.controller;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.IAccountService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by mgf on 2017/8/3.
 * 账号管理
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {

    @Resource
    private IAccountService accountService;

    @RequestMapping("/accountList")
    public JsonResult accountList() {
        Page<User> accountList = accountService.getAccountList(getPageRequest("createTime", "desc"));
        return JsonResult.success(accountList.getContent());
    }
}
