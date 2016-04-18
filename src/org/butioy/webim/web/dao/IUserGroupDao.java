package org.butioy.webim.web.dao;

import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.domain.UserGroup;
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
public interface IUserGroupDao extends BaseDao<UserGroup, java.lang.Integer> {
	
	public java.lang.Integer insert( UserGroup userGroup );

	public void update( UserGroup userGroup );

	public void deleteById ( java.lang.Integer id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public UserGroup findById( java.lang.Integer id );

	public List<UserGroup> findList( Map params );

	public List<UserFriend> findListByGroupCode( String groupCode );
}
