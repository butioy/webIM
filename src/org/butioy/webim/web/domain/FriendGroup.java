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
public class FriendGroup  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FriendGroup";
	public static final String ALIAS_ID = "好友分组ID";
	public static final String ALIAS_FRIEND_GROUP_NAME = "好友分组名称";
	public static final String ALIAS_OWNER = "好友分组所有者账号";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_UPDATE_TIME = "更新时间";

    /**
     * 好友分组ID       db_column: ID 
     */
	private Integer id;
    /**
     * 好友分组名称       db_column: FRIEND_GROUP_NAME 
     */
	@NotBlank @Length(max=50)
	private String friendGroupName;
    /**
     * 好友分组所有者账号       db_column: OWNER 
     */
	@NotBlank @Length(max=11)
	private String owner;
    /**
     * 备注       db_column: REMARK 
     */
	@Length(max=200)
	private String remark;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */
	@NotNull 
	private Date createTime;
    /**
     * 更新时间       db_column: UPDATE_TIME 
     */
	private Date updateTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setFriendGroupName(String friendGroupName) {
		this.friendGroupName = friendGroupName;
	}
	
	public String getFriendGroupName() {
		return this.friendGroupName;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return this.owner;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
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
		return "FriendGroup{" +
			"id=" + id +
			"friendGroupName=" + friendGroupName +
			"owner=" + owner +
			"remark=" + remark +
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
		if(obj instanceof FriendGroup == false) return false;
		if(this == obj) return true;
		FriendGroup other = (FriendGroup)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

