package com.piduqu.radar.controller;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.common.utils.CommonUtils;
import com.piduqu.radar.entity.mongo.TalentResume;
import com.piduqu.radar.service.TalentDataService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.Serializable;

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
//@RequestMapping("")
public class ResumeController implements Serializable {

//    @Resource
//    private IResumeService resumeService;

    @Resource
    TalentDataService talentDataService;

    @RequestMapping("/resume/import")
    @ResponseBody
    public JsonResult resumeImport(@RequestParam(value = "file", required = false) MultipartFile file,@Valid TalentResume resume,BindingResult result){

        if(result.hasErrors()){
            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
        }
        //TODO 头像上传
        try {
            talentDataService.save(resume, "talent_resume");
        }catch (Exception e){
            e.printStackTrace();
        }

//        talentDataService.insert(resume,"resume");
//        List<InnerResume> lst=  talentDataService.getTalentDataListProjection("expert_type");
//        resumeService.save(resume);
        return JsonResult.success();
    }

    @RequestMapping("/resume/findByResumeId")
    @ResponseBody
    public JsonResult findByResumeId(@Valid String resume_id,BindingResult result){

        if(result.hasErrors()){
            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
        }
        //TODO (组合简历查询条件)
//        resumeService.find(resume_id);
        return JsonResult.success();
    }

    @RequestMapping("/statistics")
    @ResponseBody
    public JsonResult Statistics_resume(String userId){
        talentDataService.statistics();
        return JsonResult.success();
    }

    @RequestMapping("/resume/findByCondition")
    @ResponseBody
    public JsonResult findByCondition(@Valid TalentResume resume,BindingResult result){

        if(result.hasErrors()){
            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
        }
        //TODO (组合简历查询条件 )
//        resumeService.findAll();

        //TODO 结果按照首字母排序
        return JsonResult.success();
    }



    @RequestMapping("/resume/export")
    @ResponseBody
    public JsonResult export(String[] resume_id,String[] return_field,HttpServletResponse response){

//        if(result.hasErrors()){
//            return JsonResult.failure(CommonUtils.getErrorsList(result.getFieldErrors()));
//        }
        if(resume_id.length>1){
            //TODO 生成excel表格
            try{
                talentDataService.getTalentDataListByFiles(resume_id, return_field,response);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            //TODO 按照模板生成简历详情

        }

        //TODO (组合简历查询条件)
//        resumeService.findAll();
        return JsonResult.success();
    }


}
