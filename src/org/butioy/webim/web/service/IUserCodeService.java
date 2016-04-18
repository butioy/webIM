package org.butioy.webim.web.service;

import org.butioy.framework.base.BaseService;
import org.butioy.webim.web.domain.UserCode;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
public interface IUserCodeService extends BaseService<UserCode, Integer> {

	/**
	 * 生成CODE码
     */
	public void generateUserAccount( Integer total );

	/**
	 * 获取最小未使用的CODE码
     */
	public UserCode getMinUnusedAccount();

	/**
	 * 根据CODE码集合更新用户CODE码表中的使用状态
     */
	void modifyByAccounts( List<String> accounts );

}
