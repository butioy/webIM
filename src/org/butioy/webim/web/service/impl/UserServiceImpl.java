package org.butioy.webim.web.service.impl;

import com.google.common.collect.Lists;
import org.butioy.framework.util.MD5EncryptUtils;
import org.butioy.framework.util.UUIDUtils;
import org.butioy.webim.web.dao.IUserCodeDao;
import org.butioy.webim.web.domain.User;
import org.butioy.webim.web.dao.IUserDao;
import org.butioy.webim.web.domain.UserCode;
import org.butioy.webim.web.service.IUserCodeService;
import org.butioy.webim.web.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IUserCodeService userCodeService;

	@Autowired
	IUserCodeDao userCodeDao;
	
	/** 
	 * 保存User
	 */
	@Override
	public User save( User user ) {
	    Assert.notNull(user,"'user' must be not null");
	    initDefaultValuesForCreate(user);
	    //new UserChecker().checkCreateUser(user);
	    userDao.insert(user);
		List<String> accounts = Lists.newArrayList();
		accounts.add(user.getAccount());
		userCodeService.modifyByAccounts(accounts);
	    return user;
	}

	/**
	 * 批量保存User
	 */
	@Override
	public void batchSave( List<User> list ) {
		Assert.notNull(list,"'list' must be not null");
		List<String> accounts = Lists.newArrayList();
		for( User entity : list ) {
			initDefaultValuesForCreate(entity);
			accounts.add(entity.getAccount());
		}
		this.userDao.batchInsert(list);
		this.userCodeService.modifyByAccounts(accounts);
	}
	
	/** 
	 * 更新User
	 */
	@Override
    public User modify( User user ) {
        Assert.notNull(user,"'user' must be not null");
        //new UserChecker().checkUpdateUser(user);
        this.userDao.update(user);
        return user;
    }	
    
	/** 
	 * 通过主键ID删除User
	 */
	@Override
    public void deleteById( java.lang.Integer id ) {
        this.userDao.deleteById(id);
    }

	/**
	 * 通过主键id删除User；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.userDao.deleteById( java.lang.Integer.valueOf(ids.trim()) );
		} else {
			this.userDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除User
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.userDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到User
	 */
	@Override
    public User getById( java.lang.Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return userDao.findById(id);
    }

	/**
	 * 根据条件得到User集合
	 */
	@Override
	public List<User> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return userDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(User user) {
		user.setCreateTime(new Date());
		UserCode code = userCodeService.getMinUnusedAccount();
		if( null != code ) {
			user.setAccount(code.getAccount());
		}
		user.setPassword( MD5EncryptUtils.md5(user.getPassword()) );
    }

	@Override
	public User getByAccount( String account ) {
		Assert.notNull(account,"'userCode' must be not null");
		User user = userDao.findByAccount( account );
		return user;
	}
}
