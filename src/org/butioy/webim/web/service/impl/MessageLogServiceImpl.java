package org.butioy.webim.web.service.impl;

import org.butioy.webim.utils.MessageEnum;
import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.dao.IMessageLogDao;
import org.butioy.webim.web.dto.MessageDto;
import org.butioy.webim.web.service.IMessageLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-31 16:57
 * Since 2015 - 2016
 */
@Service(value = "messageLogService")
@Transactional
public class MessageLogServiceImpl implements IMessageLogService {

	@Autowired
	private IMessageLogDao messageLogDao;
	
	/** 
	 * 保存MessageLog
	 */
	@Override
	public MessageLog save( MessageLog messageLog ) {
	    Assert.notNull(messageLog,"'messageLog' must be not null");
	    initDefaultValuesForCreate(messageLog);
	    //new MessageLogChecker().checkCreateMessageLog(messageLog);
	    this.messageLogDao.insert(messageLog);
	    return messageLog;
	}
	/**
	 * 批量保存MessageLog
	 */
	@Override
	public void batchSave( List<MessageLog> list ) {
		Assert.notNull(list,"'list' must be not null");
		for( MessageLog entity : list ) {
			Assert.notNull(list,"'list' must be not null");
			initDefaultValuesForCreate(entity);
//			this.messageLogDao.insert(entity);
		}
		this.messageLogDao.batchInsert(list);
	}
	
	/** 
	 * 更新MessageLog
	 */
	@Override
    public MessageLog modify( MessageLog messageLog ) {
        Assert.notNull(messageLog,"'messageLog' must be not null");
        //new MessageLogChecker().checkUpdateMessageLog(messageLog);
        this.messageLogDao.update(messageLog);
        return messageLog;
    }

	/**
	 * 动态更新MessageLog
	 */
	@Override
	public MessageLog dynamicModify(MessageLog messageLog) {
		Assert.notNull(messageLog,"'messageLog' must be not null");
		this.messageLogDao.dynamicUpdate(messageLog);
		return messageLog;
	}

	/**
	 * 通过主键ID删除MessageLog
	 */
	@Override
    public void deleteById( java.lang.Long id ) {
        this.messageLogDao.deleteById(id);
    }

	/**
	 * 通过主键id删除MessageLog；多个id之间使用","隔开
	 */
	@Override
	public void deleteByIds( String ids ) {
		Assert.notNull(ids,"'ids' must be not null");
		if( ids.indexOf(",") != -1 ) {
			this.messageLogDao.deleteById( java.lang.Long.valueOf(ids.trim()) );
		} else {
			this.messageLogDao.deleteByIds(ids.trim());
		}
	}

    /** 
     * 删除MessageLog
     */
	@Override
    public void deleteByParam( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		this.messageLogDao.deleteByParam(params);
    }
    
	/** 
	 * 根据ID得到MessageLog
	 */
	@Override
    public MessageLog getById( java.lang.Long id ) {
		Assert.notNull(id,"'id' must be not null");
        return messageLogDao.findById(id);
    }

	/**
	 * 根据条件得到MessageLog集合
	 */
	@Override
	public List<MessageLog> getList( Map params ) {
		Assert.notNull(params,"'params' must be not null");
		return messageLogDao.findList(params);
	}
	/**
	 * 为创建时初始化相关默认值 
	 **/
    public void initDefaultValuesForCreate(MessageLog messageLog) {
    }

	/**
	 * 获取用户未消费信息集合
	 * @param fromUserCode 消息发送者code码
	 * @param toUserCode 消息接收者code码
	 * @param type 消息类型
	 * @return 消息集合
	 */
	@Override
	public List<MessageDto> getUserNonConsumeMessageList(String fromUser, String toUser, Integer msgType) {
		Assert.notNull(fromUser,"'fromUser' must be not null");
		Assert.notNull(toUser,"'toUser' must be not null");
		Assert.notNull(msgType,"'msgType' must be not null");
		return messageLogDao.findUserNonConsumeMessageList(fromUser, toUser, msgType, MessageEnum.Consume.NOT.getCode());
	}
}
