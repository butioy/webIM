package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class GroupQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 群组ID */
	private Integer id;
	/** 群组名称 */
	private String groupName;
	/** 群组CODE码 */
	private String groupCode;
	/** 群组所有者账号 */
	private String owner;
	/** 父ID */
	private Integer parentId;
	/** 分组图片地址 */
	private String img;
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
	
	public String getGroupName() {
		return this.groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String img) {
		this.img = img;
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
		return "Group{" +
				"id=" + id +
				"groupName=" + groupName +
				"groupCode=" + groupCode +
				"owner=" + owner +
				"parentId=" + parentId +
				"img=" + img +
				"remark=" + remark +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
				"updateTimeBegin=" + updateTimeBegin +
				"updateTimeEnd=" + updateTimeEnd +
		"}";
	}
	
}

