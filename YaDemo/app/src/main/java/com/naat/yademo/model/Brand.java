package com.naat.yademo.model;

import java.io.Serializable;
import java.util.List;

public class Brand implements Serializable {

    private int id;
    private String name;
    private List<Service> services;

    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Brand{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", services=" + services +
            '}';
    }
}
