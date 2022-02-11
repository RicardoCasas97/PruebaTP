package com.example.pruebatp.Repos;

import androidx.lifecycle.MutableLiveData;

import com.example.pruebatp.Cliente;
import com.example.pruebatp.Entidades.ListaReferencias;
import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.Entidades.User;
import com.example.pruebatp.Interfaz.API;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {

    private final String TAG = getClass().getSimpleName();
    public MutableLiveData<Respuesta> reqRespuesta(User user){
        final MutableLiveData<Respuesta> mutableLiveData = new MutableLiveData<>();

        API api = Cliente.getRetrofit().create(API.class);

        api.loginUsuario(user).enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (response.isSuccessful() && response.body()!=null){
                   mutableLiveData.postValue(response.body());
                }else {
                    mutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


    public MutableLiveData<ListaReferencias> reqLista(Respuesta respuesta){
        final MutableLiveData<ListaReferencias> mutableLiveData = new MutableLiveData<>();

        API api = Cliente.getRetrofit().create(API.class);

        api.ObtenerReferencias(respuesta).enqueue(new Callback<ListaReferencias>() {
            @Override
            public void onResponse(Call<ListaReferencias> call, Response<ListaReferencias> response) {
                if (response.isSuccessful() && response.body()!=null){
                    mutableLiveData.postValue(response.body());
                }else {
                    mutableLiveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<ListaReferencias> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }




}
