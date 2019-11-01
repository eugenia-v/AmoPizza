package ru.bwsite.android.amopizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GroupApi {
    @GET("goods2.json")
    Call<List<Group>> loadGroup();
}
