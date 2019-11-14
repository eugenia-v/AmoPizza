package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.Product;
import ru.bwsite.android.amopizza.DataObjects.SizePrice;
import ru.bwsite.android.amopizza.MenuActivity.AdapterMenuActivity;
import ru.bwsite.android.amopizza.R;

public class AdapterPizzaButtons extends RecyclerView.Adapter<AdapterPizzaButtons.MyViewHolder> {
    private List<SizePrice> size_price;
    private Context context;
    private RecyclerView mRecyclerView;

    public AdapterPizzaButtons(List<SizePrice> size_price, PizzaActivity context, RecyclerView recyclerView) {
        this.size_price = size_price;
        this.context = context;
        this.mRecyclerView = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPizzaButtons.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_buttons, parent, false);

        return new AdapterPizzaButtons.MyViewHolder(view);

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final AdapterPizzaButtons.MyViewHolder holder, final int position) {
        Log.d("position", String.valueOf(position));
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        /*holder.button.setText(size_price.get(position).getSize());
        int width = mRecyclerView.getMeasuredWidth();
        holder.button.setLayoutParams(new LinearLayout.LayoutParams(width / size_price.size(), 70));
        if (size_price.get(position).getSize() != null && position == 0) {
            holder.button.setBackgroundResource(R.drawable.bgalt);
        }*/
        //Log.d("rv", String.valueOf(mRecyclerView.getScrollState()));
        holder.bindSizePrice(size_price.get(position), mRecyclerView.getMeasuredWidth(), size_price.size(), position);

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return size_price.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            linearLayout = itemView.findViewById(R.id.buttons);
        }

        public void bindSizePrice(SizePrice size, int width, int buttonsCount, int position) {
            button.setText(size.getSize());
            button.setLayoutParams(new LinearLayout.LayoutParams(width / buttonsCount, 70));
            if (size.getSize() != null && position == 0) {
                button.setBackgroundResource(R.drawable.bgalt);
            }

        }
    }
}
