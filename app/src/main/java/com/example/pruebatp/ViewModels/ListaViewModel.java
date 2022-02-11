package com.example.pruebatp.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.pruebatp.Entidades.ListaReferencias;
import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.Entidades.User;
import com.example.pruebatp.Repos.Repositorio;

public class ListaViewModel extends ViewModel {
    Repositorio repositorio;
    MutableLiveData<ListaReferencias> liveData;

    public ListaViewModel() {
        this.repositorio = new Repositorio();
    }

    public LiveData<ListaReferencias> getLista(Respuesta respuesta){
        if (liveData==null){
            liveData = repositorio.reqLista(respuesta);
        }
        return liveData;
    }

}
