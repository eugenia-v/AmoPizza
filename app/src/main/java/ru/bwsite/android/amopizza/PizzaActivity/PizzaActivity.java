package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.DataObjects.SizePrice;
import ru.bwsite.android.amopizza.R;

public class PizzaActivity extends AppCompatActivity  {
    private static final String TAG = "PizzaActivity";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private AdapterPizzaActivity mAdapterPizzaActivity;
    private AdapterPizzaButtons mAdapterPizzaButtons;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.LayoutManager layoutManager2;
    private List<Product> productsList;

    private static final String EXTRA_PRODUCT = "ru.bwsite.android.amopizza.product";
    public static Intent newIntent(Context packageContext, ArrayList<Product> productsList) {
        Intent intent = new Intent(packageContext, PizzaActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_PRODUCT, productsList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        productsList = (List) getIntent().getParcelableArrayListExtra(EXTRA_PRODUCT);
        initRecyclerView();
        //initRecyclerView2();

    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapterPizzaActivity = new AdapterPizzaActivity(productsList, this);
        recyclerView.setAdapter(mAdapterPizzaActivity);
    }
   /* public void initRecyclerView2(List<SizePrice> size_price){
        recyclerView2 = findViewById(R.id.my_recycler_view2);
        layoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager2);
        mAdapterPizzaButtons = new AdapterPizzaButtons(size_price, this);
        recyclerView2.setAdapter(mAdapterPizzaButtons);
    }*/
}
