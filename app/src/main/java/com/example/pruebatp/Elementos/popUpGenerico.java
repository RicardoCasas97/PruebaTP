package com.example.pruebatp.Elementos;

import static android.content.Context.VIBRATOR_SERVICE;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Vibrator;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AlertDialog;

import com.example.pruebatp.R;

import java.util.Random;

public class popUpGenerico
{

    AlertDialog aDialog;
    Context contexto;

    public popUpGenerico(Context contexto) {
        this.contexto = contexto;
    }
    String Correcto[]={"¡Bien hecho!","¡Buen trabajo!","Trabajo completado con éxito","Tarea exitosa",
            "¡Muy bien!"};
    String Incorrecto[]={"¡Algo salió mal!","Intenta nuevamente","¡Upss! Algo salió mal","Verifica los datos","Comprueba la información","¡Upss!,Vuelve a intentar"};


    public  void popUpListener(final View view, String mensaje, boolean estado, DialogInterface.OnClickListener listener){
        try {
            String TituloAVISO = "Aviso";
            if (estado){
                TituloAVISO = Correcto[new Random().nextInt(Correcto.length)];
            }else {
                TituloAVISO = Incorrecto[new Random().nextInt(Incorrecto.length)];
            }
            final  Vibrator v = (Vibrator) contexto.getSystemService(VIBRATOR_SERVICE);

            AlertDialog.Builder builder = new AlertDialog.Builder(contexto, R.style.AlertDialog);

            String boton = "OK";
            v.vibrate(150);
            builder.setTitle(TituloAVISO);
            builder.setPositiveButton("Ok",listener);
            builder.setMessage(mensaje);
            aDialog = builder.create();
            aDialog.setIcon(R.mipmap.ic_launcher);
            aDialog.setCancelable(false);
            aDialog.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void dialogoDefault(String Titulo, String mensaje, DialogInterface.OnClickListener listenerSi,
                                DialogInterface.OnClickListener listenerNo){
        try {
            Vibrator v = (Vibrator) contexto.getSystemService(VIBRATOR_SERVICE);
            new AlertDialog.Builder(contexto,R.style.AlertDialog).setIcon(R.mipmap.ic_launcher)

                    .setTitle(Titulo).setCancelable(false)
                    .setPositiveButton("Si", listenerSi)
                    .setNegativeButton("No", listenerNo)
                    .setMessage(mensaje)
                    .show();
            v.vibrate(150);

        }catch (Exception e)
        {
            e.printStackTrace();

        }
    }
}
