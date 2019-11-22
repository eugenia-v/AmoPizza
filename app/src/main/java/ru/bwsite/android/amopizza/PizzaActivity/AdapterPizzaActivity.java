package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.R;

public class AdapterPizzaActivity extends RecyclerView.Adapter<AdapterPizzaActivity.MyViewHolder> {
    private List<Product> productList;
    private PizzaActivity context;
    private RecyclerView recyclerView2;
    private AdapterPizzaButtons mAdapterPizzaButtons;
    private LinearLayoutManager linearLayoutManager;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterPizzaActivity(List<Product> pizza, PizzaActivity context) {
        this.productList = pizza;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPizzaActivity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pizza, parent, false);

        return new MyViewHolder(view, this);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.bindProduct(productList.get(position), context, linearLayoutManager);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewDescription;
        private LinearLayout linearLayout;
        private TextView priceText;
        private RecyclerView recyclerView;
        private AdapterPizzaActivity parentAdapter;

        public MyViewHolder(View itemView, AdapterPizzaActivity parentAdapter){
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
            textViewDescription = itemView.findViewById(R.id.description);
            linearLayout = itemView.findViewById(R.id.linearlayout_itempizza);
            priceText = itemView.findViewById(R.id.price);
            recyclerView = itemView.findViewById(R.id.my_recycler_view2);
            priceText = itemView.findViewById(R.id.price);
            this.parentAdapter = parentAdapter;
        }

        public void setPriceString(String priceString) {
            priceText.setText(priceString);
        }

        public void bindProduct(final Product product, Context context, LinearLayoutManager linearLayoutManager) {
            textView.setText(product.getName());
            Glide.with(context)
                    .load(product.getImg_url())
                    .into(imageView);
            textViewDescription.setText(product.getDesc());
            linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            int width = parentAdapter.pxToDp(linearLayout.getMeasuredWidth());
            Log.d("width", String.valueOf(width));

            AdapterPizzaButtons mAdapterPizzaButtons = new AdapterPizzaButtons(product.getSize_price(), context,this, width);
            recyclerView.setAdapter(mAdapterPizzaButtons);
            priceText.setText(product.getSize_price().get(0).getPrice());

        }
    }

    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
