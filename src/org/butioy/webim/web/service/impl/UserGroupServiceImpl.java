package org.butioy.webim.web.service.impl;

import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.domain.UserGroup;
import org.butioy.webim.web.dao.IUserGroupDao;
import org.butioy.webim.web.service.IUserGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Service(value = "userGroupService")
@Transactional
public class UserGroupServiceImpl implements IUserGroupService {

	@Autowired
	private IUserGroupDao userGroupDao;
	
	/** 
	 * 保存UserGroup
	 */
	@Override
	public UserGroup save( UserGroup userGroup ) {
	    Assert.notNull(userGroup,"'userGroup' must be not null");
	    initDefaultValuesForCreate(userGroup);
	    //new UserGroupChecker().checkCreateUserGroup(userGroup);
	    this.userGroupDao.insert(userGroup);
	    return userGroup;
	}
	/**
	 * 批量保存UserGroup
	 */
	@Override
	public void batchSave( List<UserGroup> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( UserGroup entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.userGroupDao.batchInsert(list);
	}
	
	/** 
	 * 更新UserGroup
	 */
	@Override
    public UserGroup modify( UserGroup userGroup ) {
        Assert.notNull(userGroup,"'userGroup' must be not null");
        //new UserGroupChecker().checkUpdateUserGroup(userGroup);
        this.userGroupDao.update(userGroup);
        return userGroup;
    }	
    
	/** 
	 * 通过主键ID删除UserGroup
	 */
	@Override
    public void deleteById( java.lang.Integer id ) {
        this.userGroupDao.deleteById(id);
    }

	/**
	 * 通过主键id删除UserGroup；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.userGroupDao.deleteById( java.lang.Integer.valueOf(ids.trim()) );
		} else {
			this.userGroupDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除UserGroup
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.userGroupDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到UserGroup
	 */
	@Override
    public UserGroup getById( java.lang.Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return userGroupDao.findById(id);
    }

	/**
	 * 根据条件得到UserGroup集合
	 */
	@Override
	public List<UserGroup> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return userGroupDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UserGroup v) {
    }

	@Override
	public List<UserFriend> getListByGroupCode( String groupCode ) {
		Assert.notNull(groupCode,"'groupCode' must be not null");
		return userGroupDao.findListByGroupCode( groupCode );
	}
}
