package com.piduqu.radar.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.piduqu.radar.dao.IRoleDao;
import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.Role;
import com.piduqu.radar.service.IFunctionService;
import com.piduqu.radar.service.IRoleService;
import com.piduqu.radar.service.support.impl.BaseServiceImpl;
import com.piduqu.radar.entity.Function;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 *
 * @author 无聊的挂面
 * @since 2017/7/11 18:41
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IFunctionService functionService;
	
	@Override
	public IBaseDao<Role, String> getBaseDao() {
		return this.roleDao;
	}

	@Override
	public void saveOrUpdate(Role role) {
		if(role.getId() != null){
			Role dbRole = find(role.getId());
			dbRole.setUpdateTime(new Date());
			dbRole.setName(role.getName());
			dbRole.setDescription(role.getDescription());
			dbRole.setUpdateTime(new Date());
			dbRole.setStatus(role.getStatus());
			update(dbRole);
		}else{
			role.setCreateTime(new Date());
			role.setUpdateTime(new Date());
			save(role);
		}
	}

	
	
	@Override
	public void delete(String id) {
		Role role = find(id);
		Assert.state(!"administrator".equals(role.getRoleKey()),"超级管理员角色不能删除");
		super.delete(id);
	}

	@Override
	public void grant(String id, String[] resourceIds) {
		Role role = find(id);
		Assert.notNull(role, "角色不存在");
		
		Assert.state(!"administrator".equals(role.getRoleKey()),"超级管理员角色不能进行资源分配");
		Function function;
		Set<Function> functions = new HashSet<Function>();
		if(resourceIds != null){
			for (int i = 0; i < resourceIds.length; i++) {
				if(StringUtils.isBlank(resourceIds[i]) || "0".equals(resourceIds[i])){
					continue;
				}
				function = functionService.find(resourceIds[i]);
				functions.add(function);
			}
		}
		role.setFunctions(functions);
		update(role);
	}
	
}
