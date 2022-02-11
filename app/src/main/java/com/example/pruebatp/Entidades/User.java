package com.example.pruebatp.Entidades;

import com.google.gson.annotations.SerializedName;

public class User {
//user:””,password:””
    @SerializedName("user")
    private String user;

    @SerializedName("password")
    private String password;


    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
