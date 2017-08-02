package com.piduqu.radar.service.impl;

import com.piduqu.radar.common.utils.CommonUtils;
import com.piduqu.radar.common.utils.MD5Utils;
import com.piduqu.radar.dao.IUserDao;
import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.User;
import com.piduqu.radar.service.IUserService;
import com.piduqu.radar.service.support.impl.BaseServiceImpl;
import com.piduqu.radar.web.request.UserPara;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;

/**
 *
 * @author 无聊的挂面
 * @since 2017/7/11 18:42
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements IUserService {

	@Resource
	private IUserDao userDao;

	@Override
	public IBaseDao<User, String> getBaseDao() {
		return this.userDao;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void saveOrUpdate(UserPara userPara) {
		if(userPara.getId() != null){
			User dbUser = find(userPara.getId());
			dbUser.setUserEmail(userPara.getUserEmail());
			dbUser.setUpdateTime(new Date());
			update(dbUser);
		}else{
			User user = new User();
			user.setUserName(userPara.getUserName());
			user.setUserEmail(userPara.getUserEmail());
			user.setId(CommonUtils.getUUID());
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setUserStatus(0);
			user.setPassword(MD5Utils.md5("1234"));
			save(user);
		}
	}

	@Override
	public void delete(String id) {
		User user = find(id);
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能删除");
		user.setUserStatus(1);
		update(user);
	}
	
}
