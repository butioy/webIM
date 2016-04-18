package org.butioy.webim.web.query;

import java.io.Serializable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-18 15:01
 * Since 2015 - 2016
 */
public class MessageLogQuery implements Serializable {
	
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** 聊天记录ID */
	private Long id;
	/** 消息发送者账号 */
	private String fromUser;
	/** 消息接受者账号 */
	private String toUser;
	/** 消息内容 */
	private String content;
	/** 消息类型(1:普通消息, 2:群消息, 默认为1) */
	private Integer msgType;
	/** 创建时间 */
	private Date createTimeBegin;
	private Date createTimeEnd;
	/** 是否消费(0:否, 1:是) */
	private Integer consumeStatus;
	/** 消费时间 */
	private Date consumeTimeBegin;
	private Date consumeTimeEnd;

	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFromUser() {
		return this.fromUser;
	}
	
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
	public String getToUser() {
		return this.toUser;
	}
	
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getMsgType() {
		return this.msgType;
	}
	
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
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
	
	public Integer getConsumeStatus() {
		return this.consumeStatus;
	}
	
	public void setConsumeStatus(Integer consumeStatus) {
		this.consumeStatus = consumeStatus;
	}
	
	public Date getConsumeTimeBegin() {
		return this.consumeTimeBegin;
	}
	
	public void setConsumeTimeBegin(Date consumeTimeBegin) {
		this.consumeTimeBegin = consumeTimeBegin;
	}	
	
	public Date getConsumeTimeEnd() {
		return this.consumeTimeEnd;
	}
	
	public void setConsumeTimeEnd(Date consumeTimeEnd) {
		this.consumeTimeEnd = consumeTimeEnd;
	}
	

	@Override
	public String toString() {
		return "MessageLog{" +
				"id=" + id +
				"fromUser=" + fromUser +
				"toUser=" + toUser +
				"content=" + content +
				"msgType=" + msgType +
				"createTimeBegin=" + createTimeBegin +
				"createTimeEnd=" + createTimeEnd +
				"consumeStatus=" + consumeStatus +
				"consumeTimeBegin=" + consumeTimeBegin +
				"consumeTimeEnd=" + consumeTimeEnd +
		"}";
	}
	
}

