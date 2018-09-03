package com.naat.yademo.model;

import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("id_user")
    private String idUser;
    @SerializedName("user")
    private String name;
    private String pass;
    private User data;
    @SerializedName("agente")
    private String agent;
    private User error;
    private String token;
    private String message;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public User getError() {
        return error;
    }

    public void setError(User error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
