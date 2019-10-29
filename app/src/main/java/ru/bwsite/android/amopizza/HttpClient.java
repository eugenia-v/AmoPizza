package ru.bwsite.android.amopizza;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpClient {
    private static final String TAG = "HttpClient";
    private final JsonParser jsonParser;

    public HttpClient(){
        jsonParser = new JsonParser();
    }

    public List<Product> readProductInfo(String productsTitle) throws IOException, JSONException {
        String requestURL = "http://amop.bwsite.ru/goods2.json" + productsTitle;
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
        List<Product> product = jsonParser.getProducts(response);

        return product;
    }

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
