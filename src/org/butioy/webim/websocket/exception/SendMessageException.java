package org.butioy.webim.websocket.exception;

/**
 * WebSocket发送消息异常
 * Created by butioy on 2016/1/31.
 */
public class SendMessageException extends RuntimeException {

    private static final long serialVersionUID = -1597525902603965117L;

    public SendMessageException() {}

    public SendMessageException( String message ) {
        super(message);
    }

}
