package org.butioy.webim.web.dao;

import org.apache.ibatis.annotations.Param;
import org.butioy.webim.web.dto.MessageDto;
import org.springframework.stereotype.Repository;
import org.butioy.framework.base.BaseDao;
import org.butioy.webim.web.domain.MessageLog;

import java.util.Map;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-31 16:57
 * Since 2015 - 2016
 */
@Repository
public interface IMessageLogDao extends BaseDao<MessageLog, java.lang.Long> {
	
	public java.lang.Long insert( MessageLog messageLog );

	public void update( MessageLog messageLog );

	public void dynamicUpdate( MessageLog messageLog );

	public void deleteById ( java.lang.Long id );

	public void deleteByIds( String ids );

	public void deleteByParam( Map params );

	public MessageLog findById( java.lang.Long id );

	public List<MessageLog> findList( Map params );

	public List<MessageDto> findUserNonConsumeMessageList( @Param("fromUser") String fromUser,
														   @Param("toUser") String toUser,
														   @Param("msgType") Integer msgType,
														   @Param("consumeStatus") Integer consumeStatus );

}
