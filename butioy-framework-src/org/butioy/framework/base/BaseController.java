package org.butioy.framework.base;

import org.butioy.framework.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-12 20:40
 */
public class BaseController {

    /**
     * 获取会话
     * @param request
     * @return
     */
    protected HttpSession getSession( HttpServletRequest request ) {
        return request.getSession();
    }

    /**
     * 从session中回去属性值
     * @param request
     * @param sessionKey
     * @return
     */
    public static Object getSessionAttribute( HttpServletRequest request, String sessionKey ) {
        return WebUtils.getSessionAttribute(request, sessionKey);
    }

    /**
     * 删除session中 <code>key</code> 对应的属性值
     * @param request
     * @param key
     */
    protected void removeSessionAttribute( HttpServletRequest request, String key ) {
        WebUtils.removeSessionAttribute(request, key);
    }

    /**
     * 向session中添加属性
     * @param request
     * @param key
     * @param value
     */
    protected void setSessionAttribute( HttpServletRequest request, String key, Object value ) {
        WebUtils.setSessionAttribute(request, key, value);
    }

    /**
     * 向session中添加属性
     * @param request
     * @param key
     * @param value
     */
    protected void setSessionAttribute( HttpServletRequest request, String key, Object value, Integer time ) {
        WebUtils.setSessionAttribute(request, key, value, time);
    }

}
