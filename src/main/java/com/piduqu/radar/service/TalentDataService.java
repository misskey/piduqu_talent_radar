package com.piduqu.radar.service;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.entity.mongo.InnerResume;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * @author 无聊的挂面
 * @since 2017-07-19 18:03
 */
public interface TalentDataService {

    List<InnerResume> getTalentDataList(String expert_type);

    List<InnerResume> getTalentDataListProjection(String expert_type);

    List<InnerResume> getTalentDataListPage(String expert_type);

    JsonResult save(Object o,String collectionName) throws ParseException;

    List<InnerResume> getTalentDataListByFiles(String[] resume_id,String[] return_field,HttpServletResponse response) throws Exception;

    JsonResult statistics();
}
