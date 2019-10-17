package ru.bwsite.android.amopizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Pizza> pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//установка ресурса разметки дизайна
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        pizza = new ArrayList<>();
        pizza.add(new Pizza("Маргарита","kategorii/piczcza/margarita", "Томаты, сыр моцарелла, пицца-соус.","/assets/images/products/79/13-pizza.jpg"));
        pizza.add(new Pizza("Нью-Йорк","kategorii/piczcza/nyu-jork", "Ветчина, грибы, пицца-соус, сыр моцарелла", "/assets/images/products/80/7-pizza.jpg"));
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(pizza);
        recyclerView.setAdapter(mAdapter);
    }
}
