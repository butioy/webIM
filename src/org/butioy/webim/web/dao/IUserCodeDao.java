package org.butioy.webim.web.dao;

import org.butioy.webim.web.domain.UserCode;
import org.springframework.stereotype.Repository;
import org.butioy.framework.base.BaseDao;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
@Repository
public interface IUserCodeDao extends BaseDao<UserCode, Integer> {
	

	void deleteByIds(String ids);

	/** 查询最大的账号对象信息 */
	UserCode findMaxAccount();

	/** 根据账号查询对象信息 */
	UserCode findByAccount( String account );

	/** 获取最小未使用的账号 */
	UserCode findMinUnusedAccount();

	/**
	 * 根据账号集合更新用户账号表中的使用状态
	 */
	void updateByAccounts( List<String> accounts );
}
