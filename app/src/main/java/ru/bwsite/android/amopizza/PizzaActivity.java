package ru.bwsite.android.amopizza;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PizzaActivity extends AppCompatActivity implements Callback<List<Group>> {
    private static final String TAG = "PizzaActivity";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Group> groupList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        try {
            GroupApi groupApi = ApiCreator.getGroups();

            Log.d(TAG, "msg3");
            Call<List<Group>> call = groupApi.loadGroup();//подготовка к получению данных с бэка
            Log.d(TAG, "msg4");
            call.enqueue(this);//начинает выполнять асинхронно запрос к бэку

            Log.d(TAG, "msg5cll");
        } catch (Exception e) {
            Log.d(TAG, "msg12cll");
            Log.d(TAG, e.toString());
            Log.d(TAG, e.getStackTrace().toString());
        }
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(groupList, this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onResponse(Call<List<Group>> call, Response<List<Group>> response) {
        Log.d(TAG, "msg6scf");
        if (response.isSuccessful()) {
            List<Group> changesList = response.body();
            this.groupList = changesList;
            Log.d(TAG, "msg7okk");
            initRecyclerView();
        } else {
            Log.d(TAG, response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<List<Group>> call, Throwable t) {
        Log.d(TAG, "msg6fld");
        Log.d(TAG, t.toString());
        t.printStackTrace();
    }
}
