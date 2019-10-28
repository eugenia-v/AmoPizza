package ru.bwsite.android.amopizza;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Products> productsList;
    private PizzaActivity context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Products> pizza, PizzaActivity context) {
        this.productsList = pizza;
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
        holder.textView.setText(productsList.get(position).title);

        Glide.with(context)
                .load(productsList.get(position).imageResourceID)
                .into(holder.imageView);
        holder.textViewDescription.setText(productsList.get(position).description);

        final ArrayList<String> priceList = productsList.get(position).price;
        final ArrayList<String> sizeList = productsList.get(position).size;
        holder.priceText.setText(priceList.get(0));
        holder.mButton1 = (Button) holder.linearLayout.getChildAt(0);
        holder.mButton1.setText(sizeList.get(0));
        holder.mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.priceText.setText(priceList.get(0));
                holder.mButton1.setBackgroundResource(R.drawable.bgalt);
                holder.mButton2.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton3.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton4.setBackgroundResource(R.drawable.bgnorm);
            }
        });
        holder.mButton2 = (Button) holder.linearLayout.getChildAt(1);
        holder.mButton2.setText(sizeList.get(1));
        holder.mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.priceText.setText(priceList.get(1));
                holder.mButton1.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton2.setBackgroundResource(R.drawable.bgalt);
                holder.mButton3.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton4.setBackgroundResource(R.drawable.bgnorm);
            }
        });
        holder.mButton3 = (Button) holder.linearLayout.getChildAt(2);
        holder.mButton3.setText(sizeList.get(2));
        holder.mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.priceText.setText(priceList.get(2));
                holder.mButton1.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton2.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton3.setBackgroundResource(R.drawable.bgalt);
                holder.mButton4.setBackgroundResource(R.drawable.bgnorm);
            }
        });
        holder.mButton4 = (Button) holder.linearLayout.getChildAt(3);
        holder.mButton4.setText(sizeList.get(3));
        holder.mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.priceText.setText(priceList.get(3));
                holder.mButton1.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton2.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton3.setBackgroundResource(R.drawable.bgnorm);
                holder.mButton4.setBackgroundResource(R.drawable.bgalt);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productsList.size();
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
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.title);
            textViewDescription = itemView.findViewById(R.id.description);
            linearLayout = itemView.findViewById(R.id.buttons);
            priceText = itemView.findViewById(R.id.price);
        }
    }
}
