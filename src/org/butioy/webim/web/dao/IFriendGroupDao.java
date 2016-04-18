package org.butioy.webim.web.dao;

import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.FriendGroup;
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
public interface IFriendGroupDao extends BaseDao<FriendGroup, java.lang.Integer> {
	
	public java.lang.Integer insert( FriendGroup friendGroup );

	public void update( FriendGroup friendGroup );

	public void deleteById ( java.lang.Integer id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public FriendGroup findById( java.lang.Integer id );

	public List<FriendGroup> findList( Map params );

}
