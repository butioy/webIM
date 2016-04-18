package org.butioy.framework.exception;

/**
 * 公用持久化异常类
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 2015-09-28 10:54.
 */
public class PersistenceException extends RuntimeException {

    private static final long serialVersionUID = 1318228584482673449L;

    public PersistenceException() {
    }

    public PersistenceException(String message) {
        super(message);
    }
}
