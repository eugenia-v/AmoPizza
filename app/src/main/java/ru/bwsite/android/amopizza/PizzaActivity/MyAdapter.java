package ru.bwsite.android.amopizza.PizzaActivity;

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

import ru.bwsite.android.amopizza.DataObjects.Group;
import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Product> productList;
    private PizzaActivity context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Product> pizza, PizzaActivity context) {
        this.productList = pizza;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pizza, parent, false);

        return new MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(productList.get(position).getName());

/*        Glide.with(context)
                .load(productList.get(position).imageResourceID)
                .into(holder.imageView);
        holder.textViewDescription.setText(productList.get(position).description);*/

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
        private Button mButton1;
        private Button mButton2;
        private Button mButton3;
        private Button mButton4;

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
