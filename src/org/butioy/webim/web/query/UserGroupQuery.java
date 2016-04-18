package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class UserGroupQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 用户-群组关联表ID */
	private Integer id;
	/** 用户账号 */
	private String account;
	/** 群组CODE码 */
	private String groupCode;

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
	
	public String getGroupCode() {
		return this.groupCode;
	}
	
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	

	@Override
	public String toString() {
		return "UserGroup{" +
				"id=" + id +
				"account=" + account +
				"groupCode=" + groupCode +
		"}";
	}
	
}

