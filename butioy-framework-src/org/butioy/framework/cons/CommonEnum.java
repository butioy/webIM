package org.butioy.framework.cons;

/**
 * 公用枚举类
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-05 21:12
 */
public class CommonEnum {

    //用户类型枚举
    public enum USER_TYPE {
        SYSTEM(1),//系统管理员用户类型
        NORMAL(2),//普通管理员用户类型
        SUPER(5);//超级管理员用户类型
        private int code;

        USER_TYPE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    //权限类型枚举
    public enum PERMISSION_TYPE {
        MENU(1),//菜单权限类型
        TAG(2);//标签权限类型
        private int code;

        PERMISSION_TYPE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum DELETE {
        DELETE(1), UN_DELETE(0);
        private int code;

        DELETE(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public enum STATUS {
        ENABLED(1), DISABLED(0);
        private int code;

        STATUS(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

}
