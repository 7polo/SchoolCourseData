package com.apologizebao.bean;

/**
 * Created by apologizebao on 16-12-20.
 */

/**
 * 用户信息类
 */
public class UserBean {
    private String name;
    private String id;
    private String mojar;
    private String startTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMojar() {
        return mojar;
    }

    public void setMojar(String mojar) {
        this.mojar = mojar;
    }
}
