package org.butioy.webim.web.service.impl;

import org.butioy.webim.web.dao.IGroupCodeDao;
import org.butioy.webim.web.domain.GroupCode;
import org.butioy.webim.web.service.IGroupCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
@Service
@Transactional
public class GroupCodeServiceImpl implements IGroupCodeService {

	@Autowired
	private IGroupCodeDao groupCodeDao;
	
	/** 
	 * 保存GroupCode
	 */
	@Override
	public GroupCode save(GroupCode groupCode ) {
	    Assert.notNull(groupCode,"'groupCode' must be not null");
	    initDefaultValuesForCreate(groupCode);
	    //new GroupCodeChecker().checkCreateGroupCode(groupCode);
	    this.groupCodeDao.insert(groupCode);
	    return groupCode;
	}
	/**
	 * 批量保存GroupCode
	 */
	@Override
	public void batchSave( List<GroupCode> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( GroupCode entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.groupCodeDao.batchInsert(list);
	}
	
	/** 
	 * 更新GroupCode
	 */
	@Override
    public GroupCode modify( GroupCode groupCode ) {
        Assert.notNull(groupCode,"'groupCode' must be not null");
        //new GroupCodeChecker().checkUpdateGroupCode(groupCode);
        this.groupCodeDao.update(groupCode);
        return groupCode;
    }	
    
	/** 
	 * 通过主键ID删除GroupCode
	 */
	@Override
    public void deleteById( Integer id ) {
        this.groupCodeDao.deleteById(id);
    }

	/**
	 * 通过主键id删除GroupCode；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.groupCodeDao.deleteById( Integer.valueOf(ids.trim()) );
		} else {
			this.groupCodeDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除GroupCode
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.groupCodeDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到GroupCode
	 */
	@Override
    public GroupCode getById( Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return groupCodeDao.findById(id);
    }

	/**
	 * 根据条件得到GroupCode集合
	 */
	@Override
	public List<GroupCode> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return groupCodeDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(GroupCode groupCode) {
    }
}
