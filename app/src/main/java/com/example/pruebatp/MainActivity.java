package com.example.pruebatp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.pruebatp.Elementos.popUpGenerico;
import com.example.pruebatp.Entidades.Respuesta;
import com.example.pruebatp.Entidades.User;
import com.example.pruebatp.ViewModels.RespuestaViewModel;
import com.example.pruebatp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    popUpGenerico pop;
    Context context;
    Respuesta respuesta;
    FrameLayout frameLayoutProgress;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        inicializacion();
        binding.botonIngresarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(binding.usuarioEtLogin.getText())){
                    pop.popUpListener(getCurrentFocus(),getString(R.string.LlenarUsuario),false,null);
                    return;
                }
                if (TextUtils.isEmpty(binding.contraEtLogin.getText())){
                    pop.popUpListener(getCurrentFocus(),getString(R.string.LlenarPass),false,null);
                    return;
                }
                frameLayoutProgress.setVisibility(View.VISIBLE);
                User user = new User(binding.usuarioEtLogin.getText().toString(),binding.contraEtLogin.getText().toString());
                //loginViewModel.getRespuesta(user).getSession();
                try {
                    RespuestaViewModel model = new RespuestaViewModel();
                    model.getRespuesta(user).observe(MainActivity.this, new Observer<Respuesta>() {
                        @Override
                        public void onChanged(Respuesta respuesta) {
                            if (respuesta.getSession()!=null){
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putString("session", respuesta.getSession());
                                editor.apply();
                                startActivity(new Intent(context,ActivityListado.class));
                                //Toast.makeText(context,respuesta.getSession(),Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context,getString(R.string.MensajeLoginError),Toast.LENGTH_SHORT).show();
                            }

                            frameLayoutProgress.setVisibility(View.GONE);
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }


    public void inicializacion(){
        context = MainActivity.this;
        pop= new popUpGenerico(context);
        frameLayoutProgress = binding.progressBar.getRoot();
        pref= PreferenceManager.getDefaultSharedPreferences(context);

    }
}