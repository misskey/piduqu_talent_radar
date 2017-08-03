package com.piduqu.radar.service;

import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by mgf on 2017/8/3.
 */
public interface IAccountService extends IBaseService<User,String>{
    Page<User> getAccountList(PageRequest pageRequest);
}
