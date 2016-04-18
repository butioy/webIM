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
public class User  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "用户ID";
	public static final String ALIAS_NICK_NAME = "昵称";
	public static final String ALIAS_REAL_NAME = "真实姓名";
	public static final String ALIAS_ACCOUNT = "用户账号";
	public static final String ALIAS_PASSWORD = "用户密码";
	public static final String ALIAS_IMG = "头像地址";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_UPDATE_TIME = "修改时间";

    /**
     * 用户ID       db_column: ID 
     */
	private Integer id;
    /**
     * 昵称       db_column: NICK_NAME 
     */
	@NotBlank @Length(max=50)
	private String nickName;
    /**
     * 真实姓名       db_column: REAL_NAME 
     */
	@Length(max=50)
	private String realName;
    /**
     * 用户账号       db_column: ACCOUNT 
     */
	@NotBlank @Length(max=11)
	private String account;
    /**
     * 用户密码       db_column: PASSWORD 
     */
	@NotBlank @Length(max=32)
	private String password;
    /**
     * 头像地址       db_column: IMG 
     */
	@Length(max=50)
	private String img;
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
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getRealName() {
		return this.realName;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getAccount() {
		return this.account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg() {
		return this.img;
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
		return "User{" +
			"id=" + id +
			"nickName=" + nickName +
			"realName=" + realName +
			"account=" + account +
			"password=" + password +
			"img=" + img +
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
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

