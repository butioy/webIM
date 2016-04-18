package org.butioy.webim.websocket.handler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.butioy.framework.holder.ApplicationContextHolder;
import org.butioy.webim.utils.MessageEnum;
import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.service.IGroupService;
import org.butioy.webim.web.service.IMessageLogService;
import org.butioy.webim.websocket.exception.SendMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by LSL on 2016/2/13.
 */
public class MessageHandler {

    private static final Logger LOG = LoggerFactory.getLogger(MessageHandler.class);

    private static IGroupService groupService;

    private static IMessageLogService messageLogService;

    private static MessageHandler handler = null;

    private MessageHandler(){}

    public static MessageHandler getInstance() {
        if( null == handler ) {
            groupService = (IGroupService) ApplicationContextHolder.getBean("groupService");
            messageLogService = (IMessageLogService) ApplicationContextHolder.getBean("messageLogService");
            handler = new MessageHandler();
        }
        return handler;
    }

    /**
     * 推送消息
     */
    public void sendMessage( WebSocketMessage message, boolean isSave ) {
        if( null != message ) {
            if( message instanceof TextMessage) { //文本信息
                boolean sendSelf = true;
                TextMessage textMessage = (TextMessage) message;
                Map<String, String> messageMap = messageToMap(textMessage.getPayload());
                String type = messageMap.get("type");
                Integer typeFlag = MessageEnum.MessageType.valueOf(type.trim().toUpperCase()).getCode();

                if( typeFlag == MessageEnum.MessageType.OFFLINE.getCode() || typeFlag == MessageEnum.MessageType.ONLINE.getCode() ) {
                    //推送用户更改在线/离线状态的消息

                } else {
                    //推送正常的消息
                }

                String time = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                String fromUserCode = messageMap.get("from");
                String toUserCode = messageMap.get("to");
                messageMap.put("time", time);
                messageMap.put("consume", MessageEnum.Consume.IS.getCode().toString());
                messageMap.put("name", "anonymous"); //默认用户名为匿名用户
                messageMap.put("face", ""); //默认头像
                Map<String, String> userInfoMap = SessionInfoHandler.USER_INFOS.get(fromUserCode);
                if( null != userInfoMap && !userInfoMap.isEmpty() ) {
                    messageMap.put("face", userInfoMap.get("img"));
                    messageMap.put("name", userInfoMap.get("userName"));
                }
                messageMap.put("flag", MessageEnum.MessageFlag.OTHER.getCode().toString());
                String jsonMessage = MapToJsonMessage(messageMap);
                MessageLog messageLog = mapToMessageLog(messageMap);
                try {
                    if( messageLog.getMsgType() == MessageEnum.MessageType.GROUP.getCode() ) {
                        sendGroupMessage(fromUserCode, toUserCode, new TextMessage(jsonMessage));
                    } else if( messageLog.getMsgType() == MessageEnum.MessageType.ONE.getCode() ) {
                        sendMessageToUser(fromUserCode, toUserCode, new TextMessage(jsonMessage));
                    } else if( messageLog.getMsgType() == MessageEnum.MessageType.ONLINE.getCode() ||
                            messageLog.getMsgType() == MessageEnum.MessageType.OFFLINE.getCode()) {
                        isSave = false;
                        sendSelf = false;
                        sendMessageToUser(fromUserCode, toUserCode, new TextMessage(jsonMessage));
                    } else {
                        //TODO 系统消息

                    }
                } catch( SendMessageException e ) {
                    messageLog.setConsumeStatus(MessageEnum.Consume.NOT.getCode());
                    messageMap.put("consume", MessageEnum.Consume.NOT.getCode().toString());
                } catch (IOException e) {
                    messageLog.setConsumeStatus(MessageEnum.Consume.NOT.getCode());
                    messageMap.put("consume", MessageEnum.Consume.NOT.getCode().toString());
                }
//                messageMap.put("to", fromUserCode);
                messageMap.put("flag", MessageEnum.MessageFlag.SELF.getCode().toString());
                //不是自己给自己发送消息则推送消息给自己
                if( sendSelf && !fromUserCode.equals(toUserCode) ) {
                    try {
                        //推送信息给自己
                        sendMessageToUser(fromUserCode, fromUserCode, new TextMessage(MapToJsonMessage(messageMap)));
                    } catch ( SendMessageException | IOException e) {
                        //TODO 推送失败
                    }
                }
                if( isSave ) {
                    List<MessageLog> list = null;;
                    if( type.equalsIgnoreCase("group") ) {
                        list = SessionInfoHandler.GROUP_MESSAGE_LOG_MAPS.get(fromUserCode);
                        if( null == list ) {
                            list = Lists.newArrayList();
                            SessionInfoHandler.ONE_MESSAGE_LOG_MAPS.put(fromUserCode, list);
                        }
                    } else if( type.equalsIgnoreCase("one") ) {
                        list = SessionInfoHandler.ONE_MESSAGE_LOG_MAPS.get(fromUserCode);
                        if( null == list ) {
                            list = Lists.newArrayList();
                            SessionInfoHandler.ONE_MESSAGE_LOG_MAPS.put(fromUserCode, list);
                        }
                    }
                    list.add(messageLog);
                    if( list.size() >= 1000 ) {
                        saveMessages(list);
                    }
                }
            } else if( message instanceof BinaryMessage) { //二进制信息
            } else { //其他类型信息
            }
        }
    }

    public void saveMessages( List<MessageLog> list ) {
        if( null != list && !list.isEmpty() ) {
            messageLogService.batchSave(list);
        }
    }

    /**
     * 给某个用户发送消息
     * @param fromUserCode 消息发送者
     * @param toUserCode 消息接受者
     * @param message 消息对象
     */
    public void sendMessageToUser( String fromUserCode, String toUserCode, WebSocketMessage message ) throws SendMessageException, IOException {
        WebSocketSession toUser = SessionInfoHandler.CLIENTS.get(toUserCode);
        if( null != toUser && toUser.isOpen() ) {
            try {
                toUser.sendMessage(message);
                System.out.println(fromUserCode + " 发送给 " + toUserCode + " 的消息： " + message.getPayload().toString());
            } catch (IOException e) {
                LOG.error("send message to " + (toUser) + " failed!...");
                throw e;
            }
        } else {
            throw new SendMessageException("用户未登录！");
        }
    }

    /**
     * 给全部在线用户发送消息
     * @param fromUserCode 消息发送者
     * @param toGroupCode 接收消息的群组code码
     * @param message 消息对象
     */
    public void sendGroupMessage( String fromUserCode, String toGroupCode, WebSocketMessage message ) {
        List<String> userCodes = Lists.newArrayList();
        if( SessionInfoHandler.GROUP_MAPS.containsKey(toGroupCode) ) {
            userCodes = SessionInfoHandler.GROUP_MAPS.get(toGroupCode);
        } else {
            Map params = Maps.newHashMap();
            groupService.getList(params);
        }
        for( String userCode : SessionInfoHandler.CLIENTS.keySet() ) {
            if( !userCode.equals(fromUserCode) ) {
                try {
                    sendMessageToUser(fromUserCode, userCode, message);
                } catch (IOException e) {
                    //群消息推送失败
                }
            }
        }
    }

    /**
     * 用户登录后推送未读消息数量
     * @param userCode 用户的code码
     */
    public void pushUnreadMessageCount( String userCode ) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("toUserCode", userCode);
        params.put("consumeStatus", MessageEnum.Consume.NOT.getCode());
        List<MessageLog> messageLogs = messageLogService.getList(params);
        for(  int i=0; i<messageLogs.size(); i++ ) {
            MessageLog log = messageLogs.get(i);
            try {
                //推送消息
                sendMessageToUser( log.getFromUser(), log.getToUser(), new TextMessage(log.getContent()) );
            } catch (IOException e) {
                //推送未读信息失败信息失败
//                e.printStackTrace();
                messageLogs.remove(i--);
            }
        }
        //更新已消费的消息状态
        for( MessageLog log : messageLogs ) {
            log.setConsumeStatus(MessageEnum.Consume.IS.getCode());
            messageLogService.modify(log);
        }
    }

    /**
     * 把Map封装到
     * @param message
     * @return
     */
    private MessageLog mapToMessageLog( Map<String, String> message ) {
        MessageLog messageLog = null;
        if( null != message && !message.isEmpty() ) {
            messageLog = new MessageLog();
            String fromUser = message.get("from");
            messageLog.setConsumeStatus(MessageEnum.Consume.NOT.getCode());
            messageLog.setFromUser(fromUser);
            messageLog.setToUser(message.get("to"));
            messageLog.setConsumeTime(new Date());
            messageLog.setContent(message.get("content"));
            String type = message.get("type");
            messageLog.setMsgType(MessageEnum.MessageType.valueOf(type.toUpperCase()).getCode());
        }
        return messageLog;
    }

    /**
     * Map转成json消息字符串
     * @param message Map封装的消息对象
     * @return json字符串消息
     */
    public String MapToJsonMessage( Map message ) {
        if( null != message && !message.isEmpty() ) {
            Gson gson = new Gson();
            return gson.toJson(message);
        }
        return "{}";
    }

    /**
     * 把JSON格式消息转换成Map对象
     * @param message 消息内容
     * @return 转换的Map对象
     */
    public Map messageToMap( String message ) {
        if( StringUtils.isNotBlank(message) ) {
            Gson gson = new Gson();
            return gson.fromJson( message, Map.class );
        }
        return Maps.newHashMap();
    }

}
