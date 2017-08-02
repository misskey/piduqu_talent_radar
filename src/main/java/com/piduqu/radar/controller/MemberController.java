package com.piduqu.radar.controller;

import com.alibaba.fastjson.JSON;
import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.common.utils.CommonUtils;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.IMemberService;
import com.piduqu.radar.web.request.UserListRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgf on 2017/7/31.
 * 成员管理
 */

@RestController
@RequestMapping("member")
public class MemberController extends BaseController {
    @Autowired
    private IMemberService memberService;

    /**
     * 成员列表
     */
    @RequestMapping("/memberList")
    public JsonResult memberList() {
        Page<User> all = memberService.getmemberList(getPageRequest("create_time", "desc"));
        Map map = new HashMap();
        map.put("memberList", all);
        return JsonResult.success(map);
    }
}
