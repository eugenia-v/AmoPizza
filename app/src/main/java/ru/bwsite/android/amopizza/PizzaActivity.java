package ru.bwsite.android.amopizza;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {
    private static final String TAG = "PizzaActivity";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Group> groupList = new ArrayList<>();
    private HttpClient httpClient = new HttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        Log.d(TAG, "msg1");
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        Log.d(TAG, "msg2");
        try {
            Log.d(TAG, "msg3");
            String str = httpClient.readGroupInfo();
            Log.d(TAG, str);
            Log.d(TAG, "msg4");
        } catch (IOException e) {
            Log.d(TAG, "exception1");
            e.printStackTrace();
        } catch (JSONException e) {
            Log.d(TAG, "exception2");
            e.printStackTrace();
        }
        initRecyclerView();
        Log.d(TAG, "msg5");
        /*----------------------------------*/


    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(groupList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
