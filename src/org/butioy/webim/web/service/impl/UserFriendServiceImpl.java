package org.butioy.webim.web.service.impl;

import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.dao.IUserFriendDao;
import org.butioy.webim.web.dto.UserGroupFriend;
import org.butioy.webim.web.service.IUserFriendService;

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
@Service(value = "userFriendService")
@Transactional
public class UserFriendServiceImpl implements IUserFriendService {

	@Autowired
	private IUserFriendDao userFriendDao;
	
	/** 
	 * 保存UserFriend
	 */
	@Override
	public UserFriend save(UserFriend userFriend ) {
	    Assert.notNull(userFriend,"'userFriend' must be not null");
	    initDefaultValuesForCreate(userFriend);
	    //new UserFriendChecker().checkCreateUserFriend(userFriend);
	    this.userFriendDao.insert(userFriend);
	    return userFriend;
	}
	/**
	 * 批量保存UserFriend
	 */
	@Override
	public void batchSave( List<UserFriend> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( UserFriend entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.userFriendDao.batchInsert(list);
	}
	
	/** 
	 * 更新UserFriend
	 */
	@Override
    public UserFriend modify( UserFriend userFriend ) {
        Assert.notNull(userFriend,"'userFriend' must be not null");
        //new UserFriendChecker().checkUpdateUserFriend(userFriend);
        this.userFriendDao.update(userFriend);
        return userFriend;
    }	
    
	/** 
	 * 通过主键ID删除UserFriend
	 */
	@Override
    public void deleteById( java.lang.Integer id ) {
        this.userFriendDao.deleteById(id);
    }

	/**
	 * 通过主键id删除UserFriend；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.userFriendDao.deleteById( java.lang.Integer.valueOf(ids.trim()) );
		} else {
			this.userFriendDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除UserFriend
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.userFriendDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到UserFriend
	 */
	@Override
    public UserFriend getById( java.lang.Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return userFriendDao.findById(id);
    }

	/**
	 * 根据条件得到UserFriend集合
	 */
	@Override
	public List<UserFriend> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return userFriendDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UserFriend v) {
    }

	@Override
	public List<UserGroupFriend> getListByOwner(String owner) {
		Assert.notNull(owner,"'owner' must be not null");
		return userFriendDao.findListByOwner(owner);
	}
}
