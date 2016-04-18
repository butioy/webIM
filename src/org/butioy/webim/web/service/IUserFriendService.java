package org.butioy.webim.web.service;

import org.butioy.framework.base.BaseService;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.dto.UserGroupFriend;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
public interface IUserFriendService extends BaseService<UserFriend, java.lang.Integer> {

	public List<UserGroupFriend> getListByOwner( String owner );

}
