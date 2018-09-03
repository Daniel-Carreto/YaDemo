package com.naat.yademo.model;

public enum TypeService {
    TIEMPO_AIRE("tiempo aire"),
    MEGAS("megas");

    private String type;
    TypeService(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }
}
