package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.R;

public class AdapterPizzaActivity extends RecyclerView.Adapter<AdapterPizzaActivity.MyViewHolder> {
    private List<Product> productList;
    private PizzaActivity context;

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

        return new MyViewHolder(view, context);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(productList.get(position).getName());
        Glide.with(context)
                .load(productList.get(position).getImg_url())
                .into(holder.imageView);
        holder.textViewDescription.setText(productList.get(position).getDesc());

        int buttonCount = productList.get(position).getSize_price().size();

        for (int i = 0; i < buttonCount; i++) {
            holder.priceText.setText(productList.get(position).getSize_price().get(i).getPrice());
            if (productList.get(position).getSize_price().get(i).getSize() != null) {
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                Button myButton = new Button(context);
                myButton.setText(productList.get(position).getSize_price().get(i).getSize());
                holder.linearLayout.addView(myButton, lp);
            }
        }

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
        private Button button;


        public MyViewHolder(View itemView, Context context) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
            textViewDescription = itemView.findViewById(R.id.description);
            linearLayout = itemView.findViewById(R.id.buttons);

            priceText = itemView.findViewById(R.id.price);
        }
    }
}
