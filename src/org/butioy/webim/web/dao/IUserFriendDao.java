package org.butioy.webim.web.dao;

import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.dto.UserGroupFriend;
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
public interface IUserFriendDao extends BaseDao<UserFriend, java.lang.Integer> {
	
	public java.lang.Integer insert( UserFriend userFriend );

	public void update( UserFriend userFriend );

	public void deleteById ( java.lang.Integer id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public UserFriend findById( java.lang.Integer id );

	public List<UserFriend> findList( Map params );

	public List<UserGroupFriend> findListByOwner( String owner );

}
