package ru.bwsite.android.amopizza;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PizzaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView pizzaTitle;
    private List<Products> productsList = new ArrayList<>();
    private String[] priceArray1 = new String[]{"290", "430", "590", "840"};
    private String[] priceArray2 = new String[]{"370", "495", "640", "890"};
    private String[] priceArray3 = new String[]{"390", "530", "690", "990"};
    /*private Map<String, String> price_size1 = new HashMap<>();
    private Map<String, String> price_size2 = new HashMap<>();
    private Map<String, String> price_size3 = new HashMap<>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна

        initRecyclerView();

        /*----------------------------------*/

        productsList.add(new Products("Пицца","Маргарита", R.drawable.margarita, "Томаты, сыр моцарелла, пицца-соус", priceArray1));
        productsList.add(new Products("Пицца","Нью-Йорк", R.drawable.newjork, "Ветчина, грибы, пицца-соус, сыр моцарелла", priceArray2));
        productsList.add(new Products("Пицца","Пепперони", R.drawable.pepperoni, "Колбаски Пепперони, сыр моцарелла, пицца-соус", priceArray2));
        productsList.add(new Products("Пицца","Вегетарианская", R.drawable.vegetarianskaya, "Томаты, грибы, перец болгарский, пицца-соус, сыр фета, сыр моцарелла, маслины", priceArray2));
        productsList.add(new Products("Пицца","Морская", R.drawable.morskaya, "Пицца соус, креветки, сладкий перец, маслины, сыр моцарелла", priceArray3));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(productsList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
