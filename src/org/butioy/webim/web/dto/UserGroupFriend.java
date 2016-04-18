package org.butioy.webim.web.dto;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by butioy on 2016/1/31.
 */
public class UserGroupFriend {

    private String name;

    private Integer nums;

    private Integer id;

    private List<UserFriend> item = Lists.newArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<UserFriend> getItem() {
        return item;
    }

    public void setItem(List<UserFriend> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "UserGroupFriend{" +
                "name='" + name + '\'' +
                ", nums=" + nums +
                ", id=" + id +
                ", item=" + item +
                '}';
    }
}
