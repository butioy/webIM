package org.butioy.framework.cons;

/**
 * 公共常量类
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-12-16 13:41
 */
public class Constants {

    //用户登录后的cookie名称
    public static final String REMEMBER_ACCOUNT_COOKIE_KEY = "ACCOUNT_COOKIE_KEY";
    //登录用户的session key
    public static final String LOGIN_SESSION_USER_KEY = "SESSION_USER_KEY";
    //登录用户的用户名，用在socket连接中根据用户名发送消息使用
    public static final String LOGIN_USER_INFO_MAP_KEY = "USER_INFO_MAP_KEY";
    //当前登录用户的部门集合key
    public static final String DEPARTMENT_LIST_KEY = "DEPARTMENT_LIST";
    //当前登录用户所选部门下的菜单集合key
    public static final String MENU_LIST_KEY = "MENU_LIST";
    //当前登录用户所选的部门KEY
    public static final String CURRENT_DEPARTMENT_KEY = "CURRENT_DEPARTMENT";
    //当前登录用户所操作的菜单组key
    public static final String CURRENT_MENU_KEY = "CURRENT_MENU";
    //当前登录用户所操作的权限key
    public static final String CURRENT_PERM_KEY = "CURRENT_PERM";
    //请求是所附带的权限ID的key
    public static final String AUTH_PERM_PARAM_KEY = "AUTH_PERM_ID";
    //跳转的来源地址
    public static final String FROM_URL = "FROM_URL";
}
