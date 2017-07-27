package com.piduqu.radar.service;

import com.piduqu.radar.entity.mongo.InnerResume;

import java.util.List;

/**
 * @author 无聊的挂面
 * @since 2017-07-19 18:03
 */
public interface TalentDataService {

    List<InnerResume> getTalentDataList(String expert_type);

    List<InnerResume> getTalentDataListProjection(String expert_type);

    List<InnerResume> getTalentDataListPage(String expert_type);
}
