package com.example.pruebatp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.Entidades.User;
import com.example.pruebatp.Repos.Repositorio;

public class RespuestaViewModel extends ViewModel {
    Repositorio repositorio;
    MutableLiveData<Respuesta> liveData;

    public RespuestaViewModel() {
        this.repositorio = new Repositorio();
    }

    public LiveData<Respuesta> getRespuesta(User user){
        if (liveData==null){
            liveData = repositorio.reqRespuesta(user);
        }
        return liveData;
    }
}
