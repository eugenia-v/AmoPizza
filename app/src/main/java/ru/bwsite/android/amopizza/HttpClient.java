package ru.bwsite.android.amopizza;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    private final JsonParser jsonParser;

    public HttpClient(){
        jsonParser = new JsonParser();
    }

    public Products readProductsInfo(String productsTitle) throws IOException, JSONException {
        String requestURL = "http://amop.bwsite.ru/goods.json" + productsTitle;
        URL url = new URL(requestURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // add auth header to request
        String authHeader = getAuthHeader(requestURL);
        connection.setRequestProperty(HEADER_AUTHORIZATION, authHeader);

        connection.connect();

        InputStream in;
        int status = connection.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            in = connection.getErrorStream();
        } else {
            in = connection.getInputStream();
        }

        String response = convertStreamToString(in);
        Products products = jsonParser.getProducts(response);

        return products;
    }
}
