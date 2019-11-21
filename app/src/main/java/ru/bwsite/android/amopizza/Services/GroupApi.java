package ru.bwsite.android.amopizza.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.bwsite.android.amopizza.DataObjects.Groupp;


/**
 * описание эндпоинтов, к которым хотим обращаться
 * прописываем, что должен вовр-ть метод loadGroup()
 * сам Call возвр-ет List<Groupp> после методов execute или enqueue
 */

public interface GroupApi {
    @GET("goods2.json")
    Call<List<Groupp>> loadGroup();
}