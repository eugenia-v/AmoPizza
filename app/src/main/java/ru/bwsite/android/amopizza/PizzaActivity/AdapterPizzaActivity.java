package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
    private static final int VIEW_ORDINARY = 0;
    private static final int VIEW_WITH_EXTRA_TEXT_VIEW = 1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterPizzaActivity(List<Product> pizza, PizzaActivity context) {
        this.productList = pizza;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPizzaActivity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        if (viewType == VIEW_WITH_EXTRA_TEXT_VIEW) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pizza_buttons, parent, false);
            return new PizzaButtonsHolder(itemView);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_pizza, parent, false);

            return new MyViewHolder(view);
        }
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

/*        if (getItemViewType(position) == VIEW_WITH_EXTRA_TEXT_VIEW) {
            int buttonCount = productList.get(position).getSize_price().size();
            Log.d("createButton1", String.valueOf(position));

            for (int i = 0; i < buttonCount - 2; i++) {
                Log.d("createButton2", String.valueOf(position));
                if (productList.get(position).getSize_price().get(i).getSize() != null) {
                    Log.d("createButton3", String.valueOf(position));
                    holder.priceText.setText(productList.get(position).getSize_price().get(i).getPrice());
                    ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    Button myButton = new Button(context);
                    myButton.setText(productList.get(position).getSize_price().get(i).getSize());
                    holder.linearLayout.addView(myButton, lp);

                }
            }
        }*/

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public int getItemViewType(int position) {

            if (position == 7) {
                return VIEW_WITH_EXTRA_TEXT_VIEW;
            } else {
                return VIEW_ORDINARY;
            }

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private TextView textViewDescription;
        private LinearLayout linearLayout;
        private TextView priceText;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.image);
            textViewDescription = itemView.findViewById(R.id.description);
            linearLayout = itemView.findViewById(R.id.buttons);
            priceText = itemView.findViewById(R.id.price);
        }
    }
}
