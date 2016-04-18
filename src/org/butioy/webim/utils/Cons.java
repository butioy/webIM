package org.butioy.webim.utils;

/**
 * Created by butioy on 2016/1/31.
 */
public interface Cons {

    String SESSION_KEY = "USER_INFO";

    String WEB_SOCKET_SESSION_KEY = "WEB_SOCKET_SESSION_KEY";

    enum CodeUseStatus {
        USED(1), //已使用
        UNUSED(0); //未使用
        private int code;

        CodeUseStatus( int code ){
            this.code = code;
        }
        public Integer getCode(){
            return this.code;
        }
    }

}
