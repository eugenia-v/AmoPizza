package ru.bwsite.android.amopizza;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<Product> getProducts(String response) throws JSONException {
        JSONArray userJson = new JSONArray(response);
        List<Product> res = new ArrayList<>();
        for(int i = 0; i<userJson.length();i++){
            JSONObject obj = (JSONObject)userJson.get(i);

            String gr_name = obj.getString("gr_name");
            Product p = new Product(gr_name);
            res.add(p);
        }
        return res;
    }
}
