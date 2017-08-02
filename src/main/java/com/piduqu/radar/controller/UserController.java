package com.piduqu.radar.controller;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.common.utils.CommonUtils;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.entity.mongo.InnerResume;
import com.piduqu.radar.service.IUserService;
import com.piduqu.radar.service.TalentDataService;
import com.piduqu.radar.service.specification.SimpleSpecificationBuilder;
import com.piduqu.radar.service.specification.SpecificationOperator;
import com.piduqu.radar.web.request.UserPara;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author 无聊的挂面
 * @since 2017-07-12 15:27
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @Resource
    private TalentDataService talentDataService;

    @RequestMapping(value = { "/userList" })
//    @RequiresPermissions("user:userList:*")//权限管理;
    public String userList(String searchText, ModelMap model){
        Subject currentUser = SecurityUtils.getSubject();
        SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
        Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
        if(StringUtils.isNotBlank(searchText)){
            builder.add("userName", SpecificationOperator.Operator.eq.name(), searchText);
        }
        List<User> list = userService.findList(builder.generateSpecification(), sort);
        userService.findAll(builder.generateSpecification(), getPageRequest());
        userService.findAll(sort);

        List<InnerResume> talentDataList = talentDataService.getTalentDataList("诺贝尔奖");

        model.put("userList", list);
        model.put("searchText", searchText);
        model.put("talentDataList", talentDataList);
        return "userList";
    }

    @RequestMapping("userInfo")
    public String userInfo(@RequestParam("id") String id,ModelMap model){
        User user = userService.find(id);
        model.put("user", user);
        return "userInfo";
    }

    @RequestMapping("userEditPage")
    public String userUpdatePage(@RequestParam("id") String id,ModelMap model){
        User user = userService.find(id);
        model.put("user", user);
        return "userEditPage";
    }

    @RequestMapping("userUpdate")
    public String userUpdate(@Valid UserPara userParam, BindingResult result){
        if (result.hasErrors()){
            return CommonUtils.getErrors(result.getFieldErrors());
        }
        userService.saveOrUpdate(userParam);
        return redirect("/user/userInfo?id="+userParam.getId());
    }

    @RequestMapping("userDelete")
    @ResponseBody
    public JsonResult userDelete(@RequestParam("id") String id, ModelMap model){
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping("userAddPage")
    public String userAddPage(){
        return "userAddPage";
    }
    @RequestMapping("userAdd")
    @ResponseBody
    public JsonResult userAdd(@Valid UserPara userParam, BindingResult result){
        if (result.hasErrors()){
            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
        }
        userService.saveOrUpdate(userParam);
        return JsonResult.success();
    }

    @RequestMapping("userFilter")
    @ResponseBody
    public JsonResult userFilter(@Valid String userName,BindingResult result){
        if(result.hasErrors()){
            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
        }
        userService.findByUserName(userName);
        return JsonResult.success();
    }


}
