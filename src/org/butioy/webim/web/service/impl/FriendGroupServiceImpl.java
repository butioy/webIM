package org.butioy.webim.web.service.impl;

import org.butioy.webim.web.domain.FriendGroup;
import org.butioy.webim.web.dao.IFriendGroupDao;
import org.butioy.webim.web.service.IFriendGroupService;

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
@Service(value = "friendGroupService")
@Transactional
public class FriendGroupServiceImpl implements IFriendGroupService {

	@Autowired
	private IFriendGroupDao friendGroupDao;
	
	/** 
	 * 保存FriendGroup
	 */
	@Override
	public FriendGroup save(FriendGroup friendGroup ) {
	    Assert.notNull(friendGroup,"'friendGroup' must be not null");
	    initDefaultValuesForCreate(friendGroup);
	    //new FriendGroupChecker().checkCreateFriendGroup(friendGroup);
	    this.friendGroupDao.insert(friendGroup);
	    return friendGroup;
	}
	/**
	 * 批量保存FriendGroup
	 */
	@Override
	public void batchSave( List<FriendGroup> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( FriendGroup entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.friendGroupDao.batchInsert(list);
	}
	
	/** 
	 * 更新FriendGroup
	 */
	@Override
    public FriendGroup modify( FriendGroup friendGroup ) {
        Assert.notNull(friendGroup,"'friendGroup' must be not null");
        //new FriendGroupChecker().checkUpdateFriendGroup(friendGroup);
        this.friendGroupDao.update(friendGroup);
        return friendGroup;
    }	
    
	/** 
	 * 通过主键ID删除FriendGroup
	 */
	@Override
    public void deleteById( java.lang.Integer id ) {
        this.friendGroupDao.deleteById(id);
    }

	/**
	 * 通过主键id删除FriendGroup；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.friendGroupDao.deleteById( java.lang.Integer.valueOf(ids.trim()) );
		} else {
			this.friendGroupDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除FriendGroup
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.friendGroupDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到FriendGroup
	 */
	@Override
    public FriendGroup getById( java.lang.Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return friendGroupDao.findById(id);
    }

	/**
	 * 根据条件得到FriendGroup集合
	 */
	@Override
	public List<FriendGroup> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return friendGroupDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(FriendGroup v) {
    }
}
