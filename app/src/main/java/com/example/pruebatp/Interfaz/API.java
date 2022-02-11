package com.example.pruebatp.Interfaz;

import com.example.pruebatp.Entidades.ListaReferencias;
import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.Entidades.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("cliente.do")
    Call<Respuesta> loginUsuario(@Body User user);

   @POST("clienteresp.do")
    Call<ListaReferencias> ObtenerReferencias(@Body Respuesta respuesta);

}

