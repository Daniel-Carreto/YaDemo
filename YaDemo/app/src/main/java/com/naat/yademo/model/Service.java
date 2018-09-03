package com.naat.yademo.model;

import java.io.Serializable;

public class Service implements Serializable{

    private int id;
    private String name;
    private int icon;
    private TypeService type;

    public Service() {
    }

    public Service(int id, String name, int icon, TypeService type) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

    public int getId() {
        return id;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getType() {
        return type.getType();
    }

    public void setType(TypeService type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Service{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", icon=" + icon +
            ", type=" + type +
            '}';
    }
}
