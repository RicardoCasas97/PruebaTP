package com.example.pruebatp.Entidades;

import com.google.gson.annotations.SerializedName;

public class Respuesta {
    //session:”xxxxxxxxxxxxxxx”
    @SerializedName("session")
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Respuesta(String session) {
        this.session = session;
    }
}
