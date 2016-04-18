package org.butioy.webim.web.service;

import org.butioy.framework.base.BaseService;
import org.butioy.webim.web.domain.User;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
public interface IUserService extends BaseService<User, java.lang.Integer> {

	/**
	 * 根据账号查询用户信息
	 */
	public User getByAccount( String account );

}
