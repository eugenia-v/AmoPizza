package ru.bwsite.android.amopizza;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView pizzaTitle;
    private List<Pizza> pizzaList = new ArrayList<>();
    private String[] priceArray1 = new String[4];
    private String[] priceArray2 = new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//установка ресурса разметки дизайна

        initRecyclerView();

/*----------------------------------*/
        priceArray1[0] = "290";
        priceArray1[1] = "430";
        priceArray1[2] = "590";
        priceArray1[3] = "840";
        priceArray2[0] = "370";
        priceArray2[1] = "495";
        priceArray2[2] = "640";
        priceArray2[3] = "890";


       /* pizzaList.add(new Pizza("Маргарита", R.drawable.margarita, "Томаты, сыр моцарелла, пицца-соус", priceArray1));
        pizzaList.add(new Pizza("Нью-Йорк", R.drawable.newjork, "Ветчина, грибы, пицца-соус, сыр моцарелла", priceArray2));*/
        pizzaList.add(new Pizza("Маргарита", R.drawable.margarita, "Томаты, сыр моцарелла, пицца-соус", "200"));
        pizzaList.add(new Pizza("Нью-Йорк", R.drawable.newjork, "Ветчина, грибы, пицца-соус, сыр моцарелла", "200"));

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(pizzaList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
