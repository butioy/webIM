package org.butioy.webim.utils;

import java.util.Enumeration;

/**
 * Created by butioy on 2016/1/25.
 */
public interface MessageEnum {

    /**
     * 消息消费状态
     */
    enum Consume{
        IS(1),  //消息已消费
        NOT(0); //消息未消费
        private int code;
        Consume( int code ) {
            this.code = code;
        }
        public Integer getCode(){
            return this.code;
        }
    }

    /**
     * 保存的消息类型
     */
    enum MessageType {
        GROUP(1),  //消息类型：群消息
        ONE(2), //消息类型：用户消息
        OFFLINE(3), //系统消息：用户下线消息
        ONLINE(4), //系统消息：用户上线消息
        SYS(20);    //消息类型：系统消息
        private int code;
        MessageType( int code ) {
            this.code = code;
        }
        public Integer getCodeByName( String name ) {
            MessageType type = MessageType.valueOf(name);
            return type.code;
        }
        public Integer getCode( ){
            return this.code;
        }
    }

    /**
     * 推送消息类型
     */
    enum PushType {
        CONNECTED(1), //webSocket通信连接成功后推送的消息类型
        NORMAL(2),    //正常的消息推送类型
        CLOSE(3);     //断开webSocket通信连接的消息类型
        private int code;
        PushType( int code ) {
            this.code = code;
        }
        public Integer getCode(){
            return this.code;
        }
    }

    enum MessageFlag {
        SELF(1), //推送给自己的消息
        OTHER(0);     //推送给别人的消息
        private int code;
        MessageFlag( int code ) {
            this.code = code;
        }
        public Integer getCode(){
            return this.code;
        }
    }

}
