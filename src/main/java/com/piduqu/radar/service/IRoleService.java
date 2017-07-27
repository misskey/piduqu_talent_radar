package com.piduqu.radar.service;

import com.piduqu.radar.entity.Role;
import com.piduqu.radar.service.support.IBaseService;

/**
 *
 * @author 无聊的挂面
 * @since 2017/7/11 18:37 
 */
public interface IRoleService extends IBaseService<Role,String> {

	/**
	 * 添加或者修改角色
	 * @param role
	 */
	void saveOrUpdate(Role role);

	/**
	 * 给角色分配资源
	 * @param id 角色ID
	 * @param resourceIds 资源ids
	 */
	void grant(String id, String[] resourceIds);

}
