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
public class UserGroup  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "UserGroup";
	public static final String ALIAS_ID = "用户-群组关联表ID";
	public static final String ALIAS_ACCOUNT = "用户账号";
	public static final String ALIAS_GROUP_CODE = "群组CODE码";

    /**
     * 用户-群组关联表ID       db_column: ID 
     */
	private Integer id;
    /**
     * 用户账号       db_column: ACCOUNT 
     */
	@NotBlank @Length(max=32)
	private String account;
    /**
     * 群组CODE码       db_column: GROUP_CODE 
     */
	@NotBlank @Length(max=32)
	private String groupCode;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getAccount() {
		return this.account;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}

	@Override
	public String toString() {
		return "UserGroup{" +
			"id=" + id +
			"account=" + account +
			"groupCode=" + groupCode +
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
		if(obj instanceof UserGroup == false) return false;
		if(this == obj) return true;
		UserGroup other = (UserGroup)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

