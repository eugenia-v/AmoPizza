package ru.bwsite.android.amopizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //private RecyclerView.Adapter mAdapter;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView pizzaPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//установка ресурса разметки дизайна

        pizzaPhoto = findViewById(R.id.imageView2);

        initRecyclerView();

/*----------------------------------*/
        //pizza = new ArrayList<>();
       /* pizzaList.add(new Pizza("Маргарита","kategorii/piczcza/margarita", "Томаты, сыр моцарелла, пицца-соус.","/assets/images/products/79/13-pizza.jpg"));
        pizzaList.add(new Pizza("Нью-Йорк","kategorii/piczcza/nyu-jork", "Ветчина, грибы, пицца-соус, сыр моцарелла", "/assets/images/products/80/7-pizza.jpg"));
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(pizzaList);
        recyclerView.setAdapter(mAdapter);*/
    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        recyclerView.setAdapter(new MyAdapter());
    }
}
