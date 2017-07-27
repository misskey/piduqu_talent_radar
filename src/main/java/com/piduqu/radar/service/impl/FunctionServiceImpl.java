package com.piduqu.radar.service.impl;

import com.piduqu.radar.dao.IFunctionDao;
import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.Function;
import com.piduqu.radar.service.IFunctionService;
import com.piduqu.radar.service.IRoleService;
import com.piduqu.radar.service.support.impl.BaseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 *
 * @author 无聊的挂面
 * @since 2017/7/11 18:39
 */
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function, String>
		implements IFunctionService {

	@Autowired
	private IFunctionDao functionDao;

	@Autowired
	private IRoleService roleService;

	@Override
	public IBaseDao<Function, String> getBaseDao() {
		return this.functionDao;
	}


	@Override
	@CacheEvict(value = "functionCache")
	public void delete(String id) {
		functionDao.deleteGrant(id);
		super.delete(id);
	}
	
}
