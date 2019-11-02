package ru.bwsite.android.amopizza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * описание эндпоинтов, к которым хотим обращаться
 * прописываем, что должен вовр-ть метод loadGroup()
 * сам Call возвр-ет List<Group> после методов execute или enqueue
 */

public interface GroupApi {
    @GET("goods2.json")
    Call<List<Group>> loadGroup();
}