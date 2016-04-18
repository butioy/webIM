package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class UserFriendQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 用户-好友关联表ID */
	private Integer id;
	/** 用户账号 */
	private String user;
	/** 好友账号 */
	private String friend;
	/** 所属好友分组ID */
	private Integer friendGroupId;
	/** 创建时间 */
	private Date createTimeBegin;
	private Date createTimeEnd;
	/** 修改时间 */
	private Date updateTimeBegin;
	private Date updateTimeEnd;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getFriend() {
		return this.friend;
	}
	
	public void setFriend(String friend) {
		this.friend = friend;
	}
	
	public Integer getFriendGroupId() {
		return this.friendGroupId;
	}
	
	public void setFriendGroupId(Integer friendGroupId) {
		this.friendGroupId = friendGroupId;
	}
	
	public Date getCreateTimeBegin() {
		return this.createTimeBegin;
	}
	
	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}	
	
	public Date getCreateTimeEnd() {
		return this.createTimeEnd;
	}
	
	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
	
	public Date getUpdateTimeBegin() {
		return this.updateTimeBegin;
	}
	
	public void setUpdateTimeBegin(Date updateTimeBegin) {
		this.updateTimeBegin = updateTimeBegin;
	}	
	
	public Date getUpdateTimeEnd() {
		return this.updateTimeEnd;
	}
	
	public void setUpdateTimeEnd(Date updateTimeEnd) {
		this.updateTimeEnd = updateTimeEnd;
	}
	

	@Override
	public String toString() {
		return "UserFriend{" +
				"id=" + id +
				"user=" + user +
				"friend=" + friend +
				"friendGroupId=" + friendGroupId +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
				"updateTimeBegin=" + updateTimeBegin +
				"updateTimeEnd=" + updateTimeEnd +
		"}";
	}
	
}

