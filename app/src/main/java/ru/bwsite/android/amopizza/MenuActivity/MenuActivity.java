package ru.bwsite.android.amopizza.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import ru.bwsite.android.amopizza.DataObjects.GroupProduct;
import ru.bwsite.android.amopizza.PizzaActivity.AdapterPizzaActivity;
import ru.bwsite.android.amopizza.R;
import ru.bwsite.android.amopizza.Services.ApiCreator;
import ru.bwsite.android.amopizza.Services.GroupApi;

public class MenuActivity extends AppCompatActivity implements Callback<List<GroupProduct>> {
    private static final String TAG = "MenuActivity";
    private Button mPizzaButton;
    private RecyclerView recyclerView;
    private AdapterMenuActivity mAdapterMenuActivity;
    private List<GroupProduct> groupList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MenuActivity", "onCreate(Bundle) called");
        setContentView(R.layout.activity_menu);
        try {
            GroupApi groupApi = ApiCreator.getGroups();

            Call<List<GroupProduct>> call = groupApi.loadGroup();//подготовка к получению данных с бэка
            call.enqueue(this);//начинает выполнять асинхронно запрос к бэку

        } catch (Exception e) {
            Log.d(TAG, "error");
            Log.d(TAG, e.toString());
            Log.d(TAG, e.getStackTrace().toString());
        }

    }

     @Override
    public void onResponse(Call<List<GroupProduct>> call, Response<List<GroupProduct>> response) {
        if (response.isSuccessful()) {
            List<GroupProduct> changesList = response.body();
            this.groupList = changesList;
            initRecyclerView();
        } else {
            Log.d(TAG, response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<List<GroupProduct>> call, Throwable t) {
        Log.d(TAG, "failure");
        Log.d(TAG, t.toString());
        t.printStackTrace();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapterMenuActivity = new AdapterMenuActivity(groupList, this);
        recyclerView.setAdapter(mAdapterMenuActivity);
    }
}
