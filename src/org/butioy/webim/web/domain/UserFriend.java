package org.butioy.webim.web.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class UserFriend  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserFriend";
	public static final String ALIAS_ID = "用户-好友关联表ID";
	public static final String ALIAS_USER = "用户账号";
	public static final String ALIAS_FRIEND = "好友账号";
	public static final String ALIAS_FRIEND_GROUP_ID = "所属好友分组ID";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_UPDATE_TIME = "修改时间";

    /**
     * 用户-好友关联表ID       db_column: ID 
     */
	private Integer id;
    /**
     * 用户账号       db_column: USER 
     */
	@NotBlank @Length(max=11)
	private String user;
    /**
     * 好友账号       db_column: FRIEND 
     */
	@NotBlank @Length(max=11)
	private String friend;
    /**
     * 所属好友分组ID       db_column: FRIEND_GROUP_ID 
     */
	@NotNull
	private Integer friendGroupId;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */
	@NotNull
	private Date createTime;
    /**
     * 修改时间       db_column: UPDATE_TIME 
     */
	private Date updateTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return this.user;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}
	
	public String getFriend() {
		return this.friend;
	}
	public void setFriendGroupId(Integer friendGroupId) {
		this.friendGroupId = friendGroupId;
	}
	
	public Integer getFriendGroupId() {
		return this.friendGroupId;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime() {
		return this.updateTime;
	}

	@Override
	public String toString() {
		return "UserFriend{" +
			"id=" + id +
			"user=" + user +
			"friend=" + friend +
			"friendGroupId=" + friendGroupId +
			"createTime=" + createTime +
			"updateTime=" + updateTime +
		"}";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UserFriend == false) return false;
		if(this == obj) return true;
		UserFriend other = (UserFriend)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

