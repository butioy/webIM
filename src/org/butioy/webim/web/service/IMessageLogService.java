package org.butioy.webim.web.service;

import org.butioy.framework.base.BaseService;
import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.dto.MessageDto;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-31 16:57
 * Since 2015 - 2016
 */
public interface IMessageLogService extends BaseService<MessageLog, java.lang.Long> {

	public MessageLog dynamicModify( MessageLog messageLog );

	/**
	 * 获取用户未消费信息集合
	 * @param fromUser 消息发送者code码
	 * @param toUser 消息接收者code码
	 * @param msgType 消息类型
     * @return 消息集合
     */
	public List<MessageDto> getUserNonConsumeMessageList( String fromUser, String toUser, Integer msgType );

}
