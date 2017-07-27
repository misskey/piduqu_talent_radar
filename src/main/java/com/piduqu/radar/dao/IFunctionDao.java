package com.piduqu.radar.dao;

import com.piduqu.radar.dao.support.IBaseDao;
import com.piduqu.radar.entity.Function;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 无聊的挂面
 * @since 2017-07-11 18:30
 */
@SuppressWarnings("ALL")
@Repository
public interface IFunctionDao extends IBaseDao<Function, String> {

	@Modifying
	@Query(nativeQuery = true,value = "DELETE FROM t_role_resource WHERE resource_id = :id")
	void deleteGrant(@Param("id") String id);


}
