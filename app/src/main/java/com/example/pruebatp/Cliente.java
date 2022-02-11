package com.example.pruebatp;

import android.app.Application;

import com.example.pruebatp.Interfaz.API;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente extends Application {

    final String Tag = getClass().getSimpleName();
    private static Cliente cliente;
    private static  Retrofit retrofit= null;
    private static String BASE_URL="http://totalplayapptest.com/AppTest04-1/";


    @Override
    public void onCreate() {
        super.onCreate();
        cliente= this;
    }

    public static synchronized Cliente getInstance(){
        return cliente;
    }

    public static Retrofit getRetrofit(){
        if (retrofit==null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            retrofit= new Retrofit.Builder().client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
