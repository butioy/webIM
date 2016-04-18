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
public class MessageLog  implements java.io.Serializable{

	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "MessageLog";
	public static final String ALIAS_ID = "聊天记录ID";
	public static final String ALIAS_FROM_USER = "消息发送者账号";
	public static final String ALIAS_TO_USER = "消息接受者账号";
	public static final String ALIAS_CONTENT = "消息内容";
	public static final String ALIAS_MSG_TYPE = "消息类型(1:普通消息, 2:群消息, 默认为1)";
	public static final String ALIAS_CREATE_TIME = "创建时间";
	public static final String ALIAS_CONSUME_STATUS = "是否消费(0:否, 1:是)";
	public static final String ALIAS_CONSUME_TIME = "消费时间";

    /**
     * 聊天记录ID       db_column: ID 
     */
	private Long id;
    /**
     * 消息发送者账号       db_column: FROM_USER 
     */
	@NotBlank @Length(max=11)
	private String fromUser;
    /**
     * 消息接受者账号       db_column: TO_USER 
     */
	@NotBlank @Length(max=11)
	private String toUser;
    /**
     * 消息内容       db_column: CONTENT 
     */
	@NotBlank @Length(max=500)
	private String content;
    /**
     * 消息类型(1:普通消息, 2:群消息, 默认为1)       db_column: MSG_TYPE 
     */
	@NotNull @Max(127)
	private Integer msgType;
    /**
     * 创建时间       db_column: CREATE_TIME 
     */
	@NotNull 
	private Date createTime;
    /**
     * 是否消费(0:否, 1:是)       db_column: CONSUME_STATUS 
     */
	@NotNull @Max(127)
	private Integer consumeStatus;
    /**
     * 消费时间       db_column: CONSUME_TIME 
     */
	private Date consumeTime;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
	public String getFromUser() {
		return this.fromUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	public String getToUser() {
		return this.toUser;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	
	public Integer getMsgType() {
		return this.msgType;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setConsumeStatus(Integer consumeStatus) {
		this.consumeStatus = consumeStatus;
	}
	
	public Integer getConsumeStatus() {
		return this.consumeStatus;
	}
	public void setConsumeTime(Date consumeTime) {
		this.consumeTime = consumeTime;
	}
	
	public Date getConsumeTime() {
		return this.consumeTime;
	}

	@Override
	public String toString() {
		return "MessageLog{" +
			"id=" + id +
			"fromUser=" + fromUser +
			"toUser=" + toUser +
			"content=" + content +
			"msgType=" + msgType +
			"createTime=" + createTime +
			"consumeStatus=" + consumeStatus +
			"consumeTime=" + consumeTime +
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
		if(obj instanceof MessageLog == false) return false;
		if(this == obj) return true;
		MessageLog other = (MessageLog)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

