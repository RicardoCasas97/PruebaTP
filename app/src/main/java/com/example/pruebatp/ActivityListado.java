package com.example.pruebatp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.pruebatp.Adapters.AdapterListado;
import com.example.pruebatp.Elementos.popUpGenerico;
import com.example.pruebatp.Entidades.ListaReferencias;
import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.ViewModels.ListaViewModel;
import com.example.pruebatp.ViewModels.RespuestaViewModel;
import com.example.pruebatp.databinding.ActivityListadoBinding;
import com.example.pruebatp.databinding.ActivityMainBinding;

public class ActivityListado extends AppCompatActivity {

    ActivityListadoBinding binding;
    popUpGenerico pop;
    Context context;
    Respuesta respuesta;
    FrameLayout frameLayoutProgress;
    AdapterListado adapterListado;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityListadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializacion();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        respuesta= new Respuesta(pref.getString("session","no"));
        try {
            ListaViewModel model = new ListaViewModel();
            frameLayoutProgress.setVisibility(View.VISIBLE);
            model.getLista(respuesta).observe(ActivityListado.this, new Observer<ListaReferencias>() {
                @Override
                public void onChanged(ListaReferencias listaReferencias) {
                    if (listaReferencias!=null){
                        Log.i("String",listaReferencias.getArrayReferences().toString());
                        adapterListado.AgregarLista(listaReferencias.getArrayReferences());
                        //Toast.makeText(context,respuesta.getSession(),Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(context,getString(R.string.MensajeListaError),Toast.LENGTH_SHORT).show();
                    }

                    frameLayoutProgress.setVisibility(View.GONE);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void inicializacion(){
        context = ActivityListado.this;
        adapterListado = new AdapterListado(context);
        pop= new popUpGenerico(context);
        frameLayoutProgress = binding.progressBar.getRoot();
        pref= PreferenceManager.getDefaultSharedPreferences(context);
        binding.recyclerListado.setAdapter(adapterListado);
        binding.recyclerListado.setHasFixedSize(true);
        binding.recyclerListado.setLayoutManager(new LinearLayoutManager(context));

    }
}