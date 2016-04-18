package org.butioy.webim.web.dto;

import java.io.Serializable;

/**
 * Created by LSL on 2016/2/4.
 */
public class MessageDto implements Serializable {

    private static final long serialVersionUID = -5121557627648603084L;

    protected Long id;

    private String time;

    private String name;

    private String face;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", face='" + face + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
