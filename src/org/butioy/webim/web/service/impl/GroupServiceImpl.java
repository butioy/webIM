package org.butioy.webim.web.service.impl;

import org.butioy.webim.web.domain.Group;
import org.butioy.webim.web.dao.IGroupDao;
import org.butioy.webim.web.dto.UserGroupFriend;
import org.butioy.webim.web.service.IGroupService;

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
@Service(value = "groupService")
@Transactional
public class GroupServiceImpl implements IGroupService {

	@Autowired
	private IGroupDao groupDao;
	
	/** 
	 * 保存Group
	 */
	@Override
	public Group save(Group group ) {
	    Assert.notNull(group,"'group' must be not null");
	    initDefaultValuesForCreate(group);
	    //new GroupChecker().checkCreateGroup(group);
	    this.groupDao.insert(group);
	    return group;
	}
	/**
	 * 批量保存Group
	 */
	@Override
	public void batchSave( List<Group> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( Group entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.groupDao.batchInsert(list);
	}
	
	/** 
	 * 更新Group
	 */
	@Override
    public Group modify( Group group ) {
        Assert.notNull(group,"'group' must be not null");
        //new GroupChecker().checkUpdateGroup(group);
        this.groupDao.update(group);
        return group;
    }	
    
	/** 
	 * 通过主键ID删除Group
	 */
	@Override
    public void deleteById( java.lang.Integer id ) {
        this.groupDao.deleteById(id);
    }

	/**
	 * 通过主键id删除Group；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.groupDao.deleteById( java.lang.Integer.valueOf(ids.trim()) );
		} else {
			this.groupDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除Group
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.groupDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到Group
	 */
	@Override
    public Group getById( java.lang.Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return groupDao.findById(id);
    }

	/**
	 * 根据条件得到Group集合
	 */
	@Override
	public List<Group> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return groupDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(Group v) {
    }

	@Override
	public List<UserGroupFriend> getListByOwner( String owner ) {
		Assert.notNull(owner,"'owner' must be not null");
		return groupDao.findListByOwner(owner);
	}
}
