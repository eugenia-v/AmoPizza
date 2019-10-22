package ru.bwsite.android.amopizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView pizzaTitle;
    private List<Pizza> pizzaList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//установка ресурса разметки дизайна
        //pizzaTitle = findViewById(R.id.title);
        initRecyclerView();
       // pizzaTitle.setText();

/*----------------------------------*/

        pizzaList.add(new Pizza("Маргарита"/*,"kategorii/piczcza/margarita", "Томаты, сыр моцарелла, пицца-соус.","/assets/images/products/79/13-pizza.jpg"*/));
        pizzaList.add(new Pizza("Нью-Йорк"/*,"kategorii/piczcza/nyu-jork", "Ветчина, грибы, пицца-соус, сыр моцарелла", "/assets/images/products/80/7-pizza.jpg"*/));
        // specify an adapter (see also next example)
    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(pizzaList);
        recyclerView.setAdapter(myAdapter);
    }
}
