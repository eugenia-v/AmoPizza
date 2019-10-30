package ru.bwsite.android.amopizza;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    public List<Group> getGroup(String response) throws JSONException {
        List<Group> res = new ArrayList<>();
        JSONArray jsonArr = new JSONArray(response);
        Gson gson = new GsonBuilder().create();
        for(int i = 0; i < jsonArr.length(); i++) {
            res.add(gson.fromJson(jsonArr.get(i).toString(), Group.class));
        }
        return res;
    }
}
