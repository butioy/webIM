package org.butioy.framework.util;

import org.apache.commons.lang3.StringUtils;
import org.butioy.framework.cons.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * HttpServletRequest和HttpServletResponse的工具类
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-19 00:50
 */
public class WebUtils {

    private static final int DEFAULT_TIME_OUT = 1000*60*60*24;

    /**
     * 获取会话
     * @param request
     * @return
     */
    public static HttpSession getSession( HttpServletRequest request ) {
        return request.getSession();
    }

    /**
     * 从session中回去属性值
     * @param request
     * @param sessionKey
     * @return
     */
    public static Object getSessionAttribute( HttpServletRequest request, String sessionKey ) {
        return getSession(request).getAttribute(sessionKey);
    }

    /**
     * 删除session中 <code>key</code> 对应的属性值
     * @param request
     * @param key
     */
    public static void removeSessionAttribute( HttpServletRequest request, String key ) {
        if( StringUtils.isNotBlank(key) ) {
            getSession(request).removeAttribute(key);
        }
    }

    /**
     * 向session中添加属性
     * @param request
     * @param key
     * @param value
     */
    public static void setSessionAttribute( HttpServletRequest request, String key, Object value ) {
        if( StringUtils.isNotBlank(key) && null != value ) {
            getSession(request).setAttribute(key, value);
        }
    }

    /**
     * 向session中添加属性
     * @param request
     * @param key
     * @param value
     */
    public static void setSessionAttribute( HttpServletRequest request, String key, Object value, Integer time ) {
        if( StringUtils.isNotBlank(key) && null != value ) {
            HttpSession session = getSession(request);
            session.setMaxInactiveInterval(time == null ? DEFAULT_TIME_OUT : time);
            session.setAttribute(key, value);
        }
    }

    /**
     * 获取请求的URI
     * @param request
     * @return
     */
    public static String getURI( HttpServletRequest request ) {
        String uri = request.getServletPath();
        String contextPath = request.getContextPath();
        uri = uri.replace(contextPath, "");
        return uri;
    }
}
