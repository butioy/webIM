package org.butioy.webim.websocket.handler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.butioy.webim.utils.Cons;
import org.butioy.webim.web.domain.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.web.socket.WebSocketSession;
import sun.security.jca.GetInstance;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by LSL on 2016/2/13.
 */
public class SessionInfoHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SessionInfoHandler.class);

    private MessageHandler messageHandler = MessageHandler.getInstance();

    private static SessionInfoHandler handler = null;

    private SessionInfoHandler(){}

    public static SessionInfoHandler getInstance() {
        if( null == handler ) {
            handler = new SessionInfoHandler();
        }
        return handler;
    }

    /**
     * 当前WebSocket连接用户集合
     * key为用的的userCode,
     * value为连接的WebSocket对象
     */
    public static final Map<String, WebSocketSession> CLIENTS = Maps.newConcurrentMap();

    /**
     * 存放待持久化的消息集合
     */
    public static final List<MessageLog> MESSAGE_LIST = Lists.newArrayList();

    /**
     * 存放用户的普通消息集合
     * key:用户的key
     * value 用户发送的普通消息集合
     * 每当用户的消息集合中的数量等于1000时，会把该集合数据写入数据库，并把该集合置空
     * 如果用户断开WebSocket连接，会及时把数据写入数据库
     */
    public static final Map<String, List<MessageLog>> ONE_MESSAGE_LOG_MAPS = Maps.newConcurrentMap();

    /**
     * 存放用户的CODE码
     * key:消息推送者的CODE码
     * value：消息接收者的CODE码集合
     */
    public static final Map<String, List<String>> SEND_TO_MAPS = Maps.newConcurrentMap();

    public static final Map<String, Map<String, List<MessageLog>>> MESSAGE_LOG_MAPS = Maps.newConcurrentMap();

    /**
     * 存放用户的群组消息集合
     * key:用户的key
     * value 用户发送的群组消息集合
     * 每当用户的消息集合中的数量等于1000时，会把该集合数据写入数据库，并把该集合置空
     * 如果用户断开WebSocket连接，会及时把数据写入数据库
     */
    public static final Map<String, List<MessageLog>> GROUP_MESSAGE_LOG_MAPS = Maps.newConcurrentMap();

    /**
     * 用户信息集合，存放当前WebSocket连接用户的所有信息
     * key：用户的code码
     * value:用户登录系统时存放在session中的信息
     */
    public static final Map<String, Map<String, String>> USER_INFOS = Maps.newConcurrentMap();

    /**
     * 当前正在使用的群组信息
     * key:群组的code码
     * value:群组中所有成员的code吗集合
     */
    public static final Map<String, List<String>> GROUP_MAPS = Maps.newConcurrentMap();

    /**
     * 删除不在线的用户
     * @param session webSocket通信会话对象
     */
    public void removeUser( WebSocketSession session ) {
        String code = getUserCode(session);
        List<MessageLog> oneLists = ONE_MESSAGE_LOG_MAPS.get(code);
        List<MessageLog> groupLists = GROUP_MESSAGE_LOG_MAPS.get(code);
        try {
            if( ONE_MESSAGE_LOG_MAPS.containsKey(code) ) {
                messageHandler.saveMessages(oneLists);
            }
            if( GROUP_MESSAGE_LOG_MAPS.containsKey(code) ) {
                messageHandler.saveMessages(groupLists);
            }
            ONE_MESSAGE_LOG_MAPS.remove(code);
            GROUP_MESSAGE_LOG_MAPS.remove(code);
            SessionInfoHandler.CLIENTS.remove(code);
            SessionInfoHandler.USER_INFOS.remove(code);
        } catch (Exception e) {
            //批量插入失败的处理方法
//            e.printStackTrace();
        }
    }

    /**
     * 获取用户建立Websocket连接时存储的用户信息Map集合
     * @param session WebSocket连接对象
     * @return 保存在WebSocket会话对象中的用户信息Map集合
     */
    public Map getUserInfoMap( WebSocketSession session ) {
        Object obj = session.getAttributes().get(Cons.WEB_SOCKET_SESSION_KEY);
        Map userInfoMap = Maps.newHashMap();
        if( obj != null ) {
            userInfoMap = (Map) obj;
        }
        return userInfoMap;
    }

    /**
     * 获取用户的code码
     * @param session webSocket通信会话对象
     * @return 用户的code码
     */
    public String getUserCode( WebSocketSession session ) {
        Map userInfoMap = getUserInfoMap(session);
        String userCode = null;
        Object obj = userInfoMap.get("userCode");
        userCode = obj != null ? obj.toString() : null;
        return userCode;
    }

}
