package org.butioy.webim.web.dto;

import java.io.Serializable;

/**
 * Created by butioy on 2016/1/31.
 */
public class UserFriend implements Serializable {

    private static final long serialVersionUID = 6917854863742518216L;

    private String id;

    private String name;

    private String face;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserFriend{" +
                "face='" + face + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
