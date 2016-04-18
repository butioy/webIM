package org.butioy.framework.resp;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-05 11:51
 */
public class RespBean implements Serializable {

    private static final long serialVersionUID = 8673636141868552667L;

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String ERROR = "error";

    private String status = FAIL;

    private String code;

    private String message;

    private Object data;

    public RespBean() {
        this.status = FAIL;
        this.message = "操作失败！";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setFailMessage( String message ) {
        this.status = FAIL;
        this.message = message;
    }

    public void setErrorMessage( String message ) {
        this.status = ERROR;
        this.message = message;
    }

    public void setSuccessMessge( String message ) {
        this.status = SUCCESS;
        this.message = message;
    }

    public void setSuccessData( Object data ) {
        setSuccessMessge("操作成功");
        this.data = data;
    }

    @Override
    public String toString() {
        ByteArrayOutputStream bos = null;
        JsonGenerator jsonGenerator = null;
        bos = new ByteArrayOutputStream();
        try {
            jsonGenerator = new ObjectMapper().getFactory().createGenerator(bos, JsonEncoding.UTF8);
            jsonGenerator.writeObject(this);
            return new String(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( null != jsonGenerator ) {
                try {
                    jsonGenerator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if( null != bos ) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
