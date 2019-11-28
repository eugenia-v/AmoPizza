package ru.bwsite.android.amopizza.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * подготавливает АPI для получения данных с бэка
 * выдает соответствующие API с параметрами запроса
 */

public class ApiCreator {
    static String BASE_URL = "http://amop.bwsite.ru/";
    private static final String TAG = "ApiCreator";

    /**
     *
     * @return объект класса, который имплементит GroupApi
     */

    public static GroupApi getGroups(){
        Log.d(TAG, "msg7");
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        Log.d(TAG, "msg8");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Log.d(TAG, "msg9");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Log.d(TAG, "msg10");
        new ArrayList<String>();
        return retrofit.create(GroupApi.class);
    }
}
