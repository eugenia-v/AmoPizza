package ru.bwsite.android.amopizza;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public Products getProducts(String response) throws JSONException {
        JSONObject userJson = new JSONObject(response);
        String title = userJson.getString("title");
        return new Products(title);
    }
}
