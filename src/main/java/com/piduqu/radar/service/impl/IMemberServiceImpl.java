package com.piduqu.radar.service.impl;

import com.piduqu.radar.common.JsonResult;
import com.piduqu.radar.dao.IUserDao;
import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.IMemberService;
import com.piduqu.radar.service.specification.SimpleSpecification;
import com.piduqu.radar.service.specification.SimpleSpecificationBuilder;
import com.piduqu.radar.service.specification.SpecificationOperator;
import com.piduqu.radar.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mgf on 2017/7/31.
 */
@Service
public class IMemberServiceImpl extends BaseServiceImpl<User, String> implements IMemberService {

    @Resource
    private IUserDao userDao;



    @Override
    public IBaseDao<User, String> getBaseDao() {
        return this.userDao;
    }

    @Override
    public Page<User> getmemberList(Pageable pageRequest) {
        SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();

        builder.add("pID", SpecificationOperator.Operator.likeL.name(), "001");
        builder.add("locked", SpecificationOperator.Operator.eq.name(), 0);
        Page<User> all = findAll(builder.generateSpecification(), pageRequest);
        return all;
    }
}
