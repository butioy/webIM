package org.butioy.webim.websocket.handler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

/**
 * webSocket的句柄，发送消息、登记/删除websocket连接用户
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-12-16 13:34
 */
public class WebSocketHandlerImpl implements WebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketHandlerImpl.class);

    private MessageHandler messageHandler = MessageHandler.getInstance();

    private SessionInfoHandler sessionInfoHandler = SessionInfoHandler.getInstance();

    /**
     * websocket通信连接成功后的回调方法
     * @param session 本次websocket通信连接的会话对象
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userCode = sessionInfoHandler.getUserCode(session);
        LOG.debug("user["+userCode+"] connect to the WebSocket success......");
        if( StringUtils.isNotBlank(userCode) ) {
            SessionInfoHandler.CLIENTS.put(userCode, session);
            SessionInfoHandler.USER_INFOS.put(userCode, sessionInfoHandler.getUserInfoMap(session));
            //推送未读消息数量
//            pushUnreadMessageCount(userCode);
        }
    }

    /**
     * 发送消息
     * @param webSocketSession 发送者webSocket会话对象
     * @param webSocketMessage 发送的消息对象
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage webSocketMessage) throws Exception {
        messageHandler.sendMessage( webSocketMessage, true );
    }

    /**
     * 处理传输错误时的回调方法
     * @param session webSocket通信会话对象
     * @param throwable 异常信息
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        if(session.isOpen()){
            //TODO 给用户推送发送消息失败提醒
//            session.close();
        }
//        LOG.debug("websocket connection closed......");
//        removeUser(session);
    }

    /**
     * webSocket通信连接断开后的回调方法
     * @param session webSocket通信会话对象
     * @param closeStatus webSocket通信关闭状态
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        LOG.debug("WebSocket connection disconnected by the user["+sessionInfoHandler.getUserCode(session)+"]......");
        //删除用户WebSocket连接信息
        sessionInfoHandler.removeUser(session);
    }

    /**
     * 是否开启分片传输消息
     * 如果底层的WebSocket支持分片传输消息，则可以返回true，否则请返回false
     * 如果有一个比较大的消息或不知大小的消息，可以让此方法返回true，
     * 是消息可以分片传输
     * @return
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
