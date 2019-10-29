package ru.bwsite.android.amopizza;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Product> productList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна

        initRecyclerView();

        /*----------------------------------*/

    HttpClient httpClient = new HttpClient();
        productList.add(new Product(httpClient.readProductInfo("gr_name")));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(productList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
