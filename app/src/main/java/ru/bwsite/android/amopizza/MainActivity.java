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
    private String[] priceArray1 = new String[]{"290", "430", "590", "840"};
    private String[] priceArray2 = new String[]{"370", "495", "640", "890"};
    private String[] priceArray3 = new String[]{"390", "530", "690", "990"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//установка ресурса разметки дизайна

        initRecyclerView();

        /*----------------------------------*/

        pizzaList.add(new Pizza("Маргарита", R.drawable.margarita, "Томаты, сыр моцарелла, пицца-соус", priceArray1));
        pizzaList.add(new Pizza("Нью-Йорк", R.drawable.newjork, "Ветчина, грибы, пицца-соус, сыр моцарелла", priceArray2));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(pizzaList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
