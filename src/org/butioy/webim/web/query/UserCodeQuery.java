package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class UserCodeQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 用户账号id */
	private Integer id;
	/** 用户账号 */
	private String account;
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
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
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
		return "UserCode{" +
				"id=" + id +
				"account=" + account +
				"isUsed=" + isUsed +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
		"}";
	}
	
}

