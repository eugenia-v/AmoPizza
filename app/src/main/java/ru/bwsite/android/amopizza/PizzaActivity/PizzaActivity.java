package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.bwsite.android.amopizza.DataObjects.Group;
import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.R;

public class PizzaActivity extends AppCompatActivity  {
    private static final String TAG = "PizzaActivity";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Product> productList = new ArrayList<>();
    private static final String EXTRA_PRODUCT = "ru.bwsite.android.amopizza.product";
    public static Intent newIntent(Context packageContext, Product[] productsArray) {
        Intent intent = new Intent(packageContext, PizzaActivity.class);
        intent.putExtra(EXTRA_PRODUCT, productsArray);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        //Product productsArray = getIntent().getParcelableExtra(EXTRA_PRODUCT);
        Product[] productsArray = (Product[]) getIntent().getParcelableArrayExtra(EXTRA_PRODUCT);
        productList = Arrays.asList(productsArray);
        initRecyclerView();

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(productList, this);
        recyclerView.setAdapter(myAdapter);
    }
}
