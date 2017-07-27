package com.piduqu.radar.controller;

import com.piduqu.radar.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author 无聊的挂面
 * @since 2017-07-12 14:05
 */
@Controller
public class LoginController extends BaseController {

    @Resource
    private IUserService userService;

    @RequestMapping("loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,ModelMap model){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return redirect("/user/userList");
        } catch (AuthenticationException e) {
            model.put("message", e.getMessage());
        }
        return "loginPage";
    }

}
