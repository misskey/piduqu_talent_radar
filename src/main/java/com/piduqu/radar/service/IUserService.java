package com.piduqu.radar.service;

import com.piduqu.radar.service.support.IBaseService;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.web.request.UserPara;

import java.util.List;

/**
 *
 * @author 无聊的挂面
 * @since 2017/7/11 18:37
 */
public interface IUserService extends IBaseService<User, String> {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

	/**
	 * 增加或者修改用户
	 * @param user
	 */
	void saveOrUpdate(UserPara user);

}
