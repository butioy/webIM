package org.butioy.webim.web.dao;

import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.Group;
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
public interface IGroupDao extends BaseDao<Group, java.lang.Integer> {
	
	public java.lang.Integer insert( Group group );

	public void update( Group group );

	public void deleteById ( java.lang.Integer id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public Group findById( java.lang.Integer id );

	public List<Group> findList( Map params );

	public List<UserGroupFriend> findListByOwner( String owner );

}
