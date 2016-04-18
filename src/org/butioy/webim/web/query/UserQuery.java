package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class UserQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 用户ID */
	private Integer id;
	/** 昵称 */
	private String nickName;
	/** 真实姓名 */
	private String realName;
	/** 用户账号 */
	private String account;
	/** 用户密码 */
	private String password;
	/** 头像地址 */
	private String img;
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
	
	public String getNickName() {
		return this.nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getAccount() {
		return this.account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImg() {
		return this.img;
	}
	
	public void setImg(String img) {
		this.img = img;
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
		return "User{" +
				"id=" + id +
				"nickName=" + nickName +
				"realName=" + realName +
				"account=" + account +
				"password=" + password +
				"img=" + img +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
				"updateTimeBegin=" + updateTimeBegin +
				"updateTimeEnd=" + updateTimeEnd +
		"}";
	}
	
}

