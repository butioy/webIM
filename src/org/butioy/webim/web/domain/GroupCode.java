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
public class GroupCode  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "GroupCode";
	public static final String ALIAS_ID = "群组ID";
	public static final String ALIAS_GROUP_CODE = "群组CODE码";
	public static final String ALIAS_IS_USED = "是否使用（0:否, 1:是, 默认为0）";
	public static final String ALIAS_CREATE_TIME = "创建时间";

    /**
     * 群组ID       db_column: ID 
     */
	private Integer id;
    /**
     * 群组CODE码       db_column: GROUP_CODE 
     */
	@NotBlank @Length(max=11)
	private String groupCode;
    /**
     * 是否使用（0:否, 1:是, 默认为0）       db_column: IS_USED 
     */
	@NotNull @Max(127)
	private Integer isUsed;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */
	@NotNull 
	private Date createTime;

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	public void setIsUsed(Integer isUsed) {
		this.isUsed = isUsed;
	}
	
	public Integer getIsUsed() {
		return this.isUsed;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}

	@Override
	public String toString() {
		return "GroupCode{" +
			"id=" + id +
			"groupCode=" + groupCode +
			"isUsed=" + isUsed +
			"createTime=" + createTime +
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
		if(obj instanceof GroupCode == false) return false;
		if(this == obj) return true;
		GroupCode other = (GroupCode)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

