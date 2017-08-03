package com.piduqu.radar.service.impl;

import com.piduqu.radar.dao.IUserDao;
import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.IAccountService;
import com.piduqu.radar.service.specification.SimpleSpecificationBuilder;
import com.piduqu.radar.service.specification.SpecificationOperator;
import com.piduqu.radar.service.support.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by mgf on 2017/8/3.
 */

@Service
public class IAccountServiceImpl extends BaseServiceImpl<User,String> implements IAccountService  {

    @Resource
    private IUserDao userDao;

    @Override
    public Page<User> getAccountList(PageRequest pageRequest) {
        SimpleSpecificationBuilder<User> builder = new SimpleSpecificationBuilder<User>();
        builder.add("pID", SpecificationOperator.Operator.likeL.name(), "001");
        Page<User> all = findAll(builder.generateSpecification(), pageRequest);
        return all;
    }

    @Override
    public IBaseDao<User, String> getBaseDao() {
        return this.userDao;
    }
}
