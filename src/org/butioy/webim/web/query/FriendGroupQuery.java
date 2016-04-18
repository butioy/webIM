package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class FriendGroupQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 好友分组ID */
	private Integer id;
	/** 好友分组名称 */
	private String friendGroupName;
	/** 好友分组所有者账号 */
	private String owner;
	/** 备注 */
	private String remark;
	/** 创建时间 */
	private Date createTimeBegin;
	private Date createTimeEnd;
	/** 更新时间 */
	private Date updateTimeBegin;
	private Date updateTimeEnd;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFriendGroupName() {
		return this.friendGroupName;
	}
	
	public void setFriendGroupName(String friendGroupName) {
		this.friendGroupName = friendGroupName;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getRemark() {
		return this.remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
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
		return "FriendGroup{" +
				"id=" + id +
				"friendGroupName=" + friendGroupName +
				"owner=" + owner +
				"remark=" + remark +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
				"updateTimeBegin=" + updateTimeBegin +
				"updateTimeEnd=" + updateTimeEnd +
		"}";
	}
	
}

