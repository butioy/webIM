package org.butioy.webim.web.dto;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Created by butioy on 2016/1/31.
 */
public class IMResult implements Serializable {

    private static final long serialVersionUID = 9099382769693901680L;

    public static final int SUCCESS_STATUS = 1;

    public static final int FAIL_STATUS = 0;

    private int status;

    private String msg;

    private List data = Lists.newArrayList();

    public IMResult() {
        this( FAIL_STATUS, "fail" );
    }

    public IMResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public void setSuccessMsg( String msg ) {
        this.status = SUCCESS_STATUS;
        this.msg = msg;
    }

    public void setSuccess( List data ) {
        this.data = data;
        this.setSuccessMsg("ok");
    }

    public void setFailMsg( String msg ) {
        this.status = FAIL_STATUS;
        this.msg = msg;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.PROTECTED).create();
        return gson.toJson(this);
//        return "IMResult{" +
//                "status=" + status +
//                ", msg='" + msg + '\'' +
//                ", data=" + data +
//                '}';
    }
}
