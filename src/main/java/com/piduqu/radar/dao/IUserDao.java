package com.piduqu.radar.dao;

import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 无聊的挂面
 * @since 2017-07-11 17:26
 */
@Repository
public interface IUserDao extends IBaseDao<User, String> {

    User findByUserName(String username);

}
