package ru.bwsite.android.amopizza;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PizzaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private TextView pizzaTitle;
    private List<Product> productList = new ArrayList<>();
    /*private String[] priceArray1 = new String[]{"290", "430", "590", "840"};
    private String[] priceArray2 = new String[]{"370", "495", "640", "890"};
    private String[] priceArray3 = new String[]{"390", "530", "690", "990"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна

        initRecyclerView();

        /*----------------------------------*/
        ArrayList<String> size1 = new ArrayList<>();
        size1.add("20 см");
        size1.add("25 см");
        size1.add("30 см");
        size1.add("35 см");

        ArrayList<String> price1 = new ArrayList<>();
        price1.add("290");
        price1.add("430");
        price1.add("590");
        price1.add("840");

        ArrayList<String> price2 = new ArrayList<>();
        price1.add("370");
        price1.add("495");
        price1.add("640");
        price1.add("890");


        productList.add(new Product("Пицца","Маргарита", R.drawable.margarita, "Томаты, сыр моцарелла, пицца-соус", price1, size1));
        productList.add(new Product("Пицца","Нью-Йорк", R.drawable.newjork, "Ветчина, грибы, пицца-соус, сыр моцарелла", price1, size1));
        productList.add(new Product("Пицца","Пепперони", R.drawable.pepperoni, "Колбаски Пепперони, сыр моцарелла, пицца-соус", price1, size1));
        productList.add(new Product("Пицца","Вегетарианская", R.drawable.vegetarianskaya, "Томаты, грибы, перец болгарский, пицца-соус, сыр фета, сыр моцарелла, маслины", price1, size1));
        productList.add(new Product("Пицца","Морская", R.drawable.morskaya, "Пицца соус, креветки, сладкий перец, маслины, сыр моцарелла", price1, size1));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(productList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
