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
public class Group  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Group";
	public static final String ALIAS_ID = "群组ID";
	public static final String ALIAS_GROUP_NAME = "群组名称";
	public static final String ALIAS_GROUP_CODE = "群组CODE码";
	public static final String ALIAS_OWNER = "群组所有者账号";
	public static final String ALIAS_PARENT_ID = "父ID";
	public static final String ALIAS_IMG = "分组图片地址";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_UPDATE_TIME = "更新时间";

    /**
     * 群组ID       db_column: ID 
     */
	private Integer id;
    /**
     * 群组名称       db_column: GROUP_NAME 
     */
	@NotBlank @Length(max=50)
	private String groupName;
    /**
     * 群组CODE码       db_column: GROUP_CODE 
     */
	@NotBlank @Length(max=11)
	private String groupCode;
    /**
     * 群组所有者账号       db_column: OWNER 
     */
	@NotBlank @Length(max=11)
	private String owner;
    /**
     * 父ID       db_column: PARENT_ID 
     */
	@NotNull
	private Integer parentId;
    /**
     * 分组图片地址       db_column: IMG 
     */
	@Length(max=100)
	private String img;
    /**
     * 备注       db_column: REMARK 
     */
	@Length(max=255)
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
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupName() {
		return this.groupName;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String getGroupCode() {
		return this.groupCode;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return this.owner;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public Integer getParentId() {
		return this.parentId;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg() {
		return this.img;
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
		return "Group{" +
			"id=" + id +
			"groupName=" + groupName +
			"groupCode=" + groupCode +
			"owner=" + owner +
			"parentId=" + parentId +
			"img=" + img +
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
		if(obj instanceof Group == false) return false;
		if(this == obj) return true;
		Group other = (Group)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

