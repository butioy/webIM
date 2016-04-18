package org.butioy.webim.web.service.impl;

import com.google.common.collect.Lists;
import org.butioy.webim.utils.CodeGenerator;
import org.butioy.webim.utils.Cons;
import org.butioy.webim.web.dao.IUserCodeDao;
import org.butioy.webim.web.domain.UserCode;
import org.butioy.webim.web.service.IUserCodeService;
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
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
@Service(value = "userCodeService")
@Transactional
public class UserCodeServiceImpl implements IUserCodeService {

	@Autowired
	private IUserCodeDao userCodeDao;
	
	/** 
	 * 保存UserCode
	 */
	@Override
	public UserCode save( UserCode userCode ) {
	    Assert.notNull(userCode,"'userCode' must be not null");
	    initDefaultValuesForCreate(userCode);
	    //new UserCodeChecker().checkCreateUserCode(userCode);
	    this.userCodeDao.insert(userCode);
	    return userCode;
	}
	/**
	 * 批量保存UserCode
	 */
	@Override
	public void batchSave( List<UserCode> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( UserCode entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
			return;
		}
		this.userCodeDao.batchInsert(list);
	}
	
	/** 
	 * 更新UserCode
	 */
	@Override
    public UserCode modify( UserCode userCode ) {
        Assert.notNull(userCode,"'userCode' must be not null");
        //new UserCodeChecker().checkUpdateUserCode(userCode);
        this.userCodeDao.update(userCode);
        return userCode;
    }	
    
	/** 
	 * 通过主键ID删除UserCode
	 */
	@Override
    public void deleteById( Integer id ) {
        this.userCodeDao.deleteById(id);
    }

	/**
	 * 通过主键id删除UserCode；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.userCodeDao.deleteById( Integer.valueOf(ids.trim()) );
		} else {
			this.userCodeDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除UserCode
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.userCodeDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到UserCode
	 */
	@Override
    public UserCode getById( Integer id ) {
		Assert.notNull(id,"'id' must be not null");
        return userCodeDao.findById(id);
    }

	/**
	 * 根据条件得到UserCode集合
	 */
	@Override
	public List<UserCode> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return userCodeDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(UserCode userCode) {
    }

	/**
	 * 生成账号码并保存
	 */
	@Override
	public void generateUserAccount( Integer total ) {
		Assert.notNull(total,"'total' must be not null");
		UserCode maxUserAccount = userCodeDao.findMaxAccount();
		String startAccount = null;
		if( null != maxUserAccount ) {
			startAccount = maxUserAccount.getAccount();
		}
		List<String> accounts = CodeGenerator.generate(startAccount, total);
		List<UserCode> userAccounts = Lists.newArrayList();
		Date curr = new Date();
		for( String account : accounts ) {
			UserCode userCode = new UserCode();
			userCode.setAccount(account);
			userCode.setCreateTime(curr);
			userCode.setIsUsed(Cons.CodeUseStatus.UNUSED.getCode());
			userAccounts.add(userCode);
			if( userAccounts.size() == 1000 ) {
				userCodeDao.batchInsert(userAccounts);
				userAccounts.clear();
			}
		}
		if( userAccounts.size() > 0 ) {
			userCodeDao.batchInsert(userAccounts);
		}
	}

	/**
	 * 获取最小未使用的账号
     */
	@Override
	public UserCode getMinUnusedAccount() {
		UserCode code = null;
		synchronized (this) {
			code = userCodeDao.findMinUnusedAccount();
		}
		return code;
	}

	/**
	 * 根据账号集合更新用户账号表中的使用状态
     */
	@Override
	public void modifyByAccounts(List<String> accounts) {
		Assert.notNull(accounts,"'accounts' must be not null");
		userCodeDao.updateByAccounts(accounts);
	}
}
