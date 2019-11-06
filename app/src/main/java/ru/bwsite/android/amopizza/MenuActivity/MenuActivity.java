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
import ru.bwsite.android.amopizza.DataObjects.Group;
import ru.bwsite.android.amopizza.PizzaActivity.AdapterPizzaActivity;
import ru.bwsite.android.amopizza.R;
import ru.bwsite.android.amopizza.Services.ApiCreator;
import ru.bwsite.android.amopizza.Services.GroupApi;

public class MenuActivity extends AppCompatActivity implements Callback<List<Group>> {
    private static final String TAG = "MenuActivity";
    private Button mPizzaButton;
    private RecyclerView recyclerView;
    private AdapterMenuActivity mAdapterMenuActivity;
    private List<Group> groupList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MenuActivity", "onCreate(Bundle) called");
        setContentView(R.layout.activity_menu);
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

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapterMenuActivity = new AdapterMenuActivity(groupList, this);
        recyclerView.setAdapter(mAdapterMenuActivity);
    }
}
