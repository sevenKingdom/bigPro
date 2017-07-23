package com.carry.model.mysql.po;

/**
 * Created by songxianying on 17/7/15.
 */

public class Configdata {
    private int id;
    private String name;
    private String data;

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
