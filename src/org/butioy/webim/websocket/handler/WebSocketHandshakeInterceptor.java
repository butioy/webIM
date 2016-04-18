package org.butioy.webim.websocket.handler;

import org.butioy.framework.util.WebUtils;
import org.butioy.webim.utils.Cons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 这个的主要作用是取得当前请求中的用户名，并且保存到当前的WebSocketHandler中，
 * 以便确定WebSocketHandler所对应的用户，具体可参考HttpSessionHandshakeInterceptor
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-12-16 14:01
 */
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler, Map<String, Object> attributes) throws Exception {
        if( request instanceof ServletServerHttpRequest ) {
            ServletServerHttpRequest req = (ServletServerHttpRequest) request;
            HttpSession session = req.getServletRequest().getSession(false);
            if( null != session ) {
                Object userInfo = WebUtils.getSessionAttribute(req.getServletRequest(), Cons.SESSION_KEY);
                if( null != userInfo ) {
                    attributes.put(Cons.WEB_SOCKET_SESSION_KEY, userInfo);
                }
            }
        }
        return true;
    }
}
