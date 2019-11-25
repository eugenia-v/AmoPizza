package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.R;

public class PizzaActivity extends AppCompatActivity  {
    private RecyclerView recyclerView;
    private AdapterPizzaActivity mAdapterPizzaActivity;
    private RecyclerView.LayoutManager layoutManager;
    private List<Product> productsList;


    private String titlePizzaActivity ="Amo pizza";
    public void setTitlePizzaActivity(String titlePizzaActivity) {
        this.titlePizzaActivity = titlePizzaActivity;
    }

    private static final String EXTRA_PRODUCT = "ru.bwsite.android.amopizza.product";
    public static Intent newIntent(Context packageContext, ArrayList<Product> productsList) {
        Intent intent = new Intent(packageContext, PizzaActivity.class);
        intent.putParcelableArrayListExtra(EXTRA_PRODUCT, productsList);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(titlePizzaActivity);
        setContentView(R.layout.activity_pizza);//установка ресурса разметки дизайна
        productsList = getIntent().getParcelableArrayListExtra(EXTRA_PRODUCT);
        initRecyclerView();
    }
    private void initRecyclerView(){
        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapterPizzaActivity = new AdapterPizzaActivity(productsList, this);
        recyclerView.setAdapter(mAdapterPizzaActivity);
    }
}
