package org.butioy.framework.bean;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-23 01:55
 */
public class KeyValue implements Serializable {

    private static final long serialVersionUID = 2929585352532306844L;

    private Object k;

    private Object v;

    public Object getK() {
        return k;
    }

    public void setK(Object k) {
        this.k = k;
    }

    public Object getV() {
        return v;
    }

    public void setV(Object v) {
        this.v = v;
    }
}
