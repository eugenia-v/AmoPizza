package ru.bwsite.android.amopizza.PizzaActivity;

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
import ru.bwsite.android.amopizza.DataObjects.Group;
import ru.bwsite.android.amopizza.R;

public class PizzaActivity extends AppCompatActivity  {
    private static final String TAG = "PizzaActivity";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Group> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        initRecyclerView();

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(productList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
