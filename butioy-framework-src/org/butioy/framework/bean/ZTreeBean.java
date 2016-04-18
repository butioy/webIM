package org.butioy.framework.bean;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-10-07 18:00
 */
public class ZTreeBean implements Serializable {

    private static final long serialVersionUID = -5061128830473818860L;

    private String id;

    private String pId = "0";

    private String name;

    private Boolean open = false;

    private Boolean chkDisabled = false;

    private Boolean checked = false;

    private Boolean isParent = false;

//    private List<ZTreeBean> childList = Lists.newArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(Boolean chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "ZTreeBean{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", open=" + open +
                ", chkDisabled=" + chkDisabled +
                ", checked=" + checked +
                ", isParent=" + isParent +
                '}';
    }
}
