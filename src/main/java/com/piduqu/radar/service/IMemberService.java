package com.piduqu.radar.service;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Created by mgf on 2017/7/31.
 */


public interface IMemberService extends IBaseService<User,String>{
    Page<User> getmemberList(Pageable pageRequest);
//    JsonResult getMemberList(Pageable pageable);
}
