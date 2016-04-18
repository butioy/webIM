package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class GroupCodeQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 群组ID */
	private Integer id;
	/** 群组CODE码 */
	private String groupCode;
	/** 是否使用（0:否, 1:是, 默认为0） */
	private Integer isUsed;
	/** 创建时间 */
	private Date createTimeBegin;
	private Date createTimeEnd;

	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public Integer getIsUsed() {
		return this.isUsed;
	}
	
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
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
	

	@Override
	public String toString() {
		return "GroupCode{" +
				"id=" + id +
				"groupCode=" + groupCode +
				"isUsed=" + isUsed +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
		"}";
	}
	
}

