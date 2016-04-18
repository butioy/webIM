package org.butioy.webim.web.dao;

import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Repository
public interface IUserDao extends BaseDao<User, java.lang.Integer> {

	public java.lang.Integer insert( User user );

	public void update( User user );

	public void deleteById ( java.lang.Integer id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public User findById( java.lang.Integer id );

	public List<User> findList( Map params );

	/** 根据账号查询用户信息 */
	public User findByAccount(String account);
}
