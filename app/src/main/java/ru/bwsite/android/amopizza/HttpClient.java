package ru.bwsite.android.amopizza;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    public Logger log = LoggerFactory.getLogger(HttpClient.class);
    static String BASE_URL = "http://amop.bwsite.ru/";
    private static final String TAG = "HttpClient";

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
        return retrofit.create(GroupApi.class);
    }

    public String readGroupInfo() throws IOException, JSONException {


        /*URL url = new URL(requestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Log.d(TAG, "msg5");
        connection.connect();
        Log.d(TAG, "msg6");
        InputStream in;
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            Log.d(TAG, "msg7");
            in = connection.getErrorStream();
        } else {
            in = connection.getInputStream();
            Log.d(TAG, "msg8");
        }

        String response = convertStreamToString(in);
        //вывести строку, посмотреть че в ней log
        //Log.d("response", response);

        //List<Group> groups = jsonParser.getGroup(response);
*/
        return "";
    }
/*
    public List<Group> readGroupInfo() throws IOException, JSONException {
        String requestURL = "http://amop.bwsite.ru/goods2.json";
        URL url = new URL(requestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.connect();

        InputStream in;
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            in = connection.getErrorStream();
        } else {
            in = connection.getInputStream();
        }

        String response = convertStreamToString(in);
        //вывести строку, посмотреть че в ней log
        //Log.d("response", response);

        List<Group> groups = jsonParser.getGroup(response);

        return groups;
    }
*/

    private String convertStreamToString(InputStream stream) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        stream.close();

        return sb.toString();
    }

}
