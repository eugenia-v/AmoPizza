package ru.bwsite.android.amopizza.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.bwsite.android.amopizza.activity.MenuActivity;
import ru.bwsite.android.amopizza.activity.PizzaActivity;
import ru.bwsite.android.amopizza.model.GroupProduct;
import ru.bwsite.android.amopizza.R;
import ru.bwsite.android.amopizza.model.Product;

public class AdapterMenuActivity extends RecyclerView.Adapter<AdapterMenuActivity.MyViewHolder> {

    private List<GroupProduct> groupList;
    private MenuActivity context;
    private int selectedItemMenuButton = -1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdapterMenuActivity(List<GroupProduct> groups, MenuActivity context) {
        this.groupList = groups;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterMenuActivity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu_button, parent, false);

        return new AdapterMenuActivity.MyViewHolder(view, this);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final AdapterMenuActivity.MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if (position == selectedItemMenuButton) {
            PizzaActivity.titlePizzaActivity = groupList.get(position).gr_name;
        }

        holder.button.setText(groupList.get(position).gr_name);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Product> productsList = groupList.get(position).products;
                Intent intent = PizzaActivity.newIntent(context, (ArrayList) productsList);
                context.startActivity(intent);
                holder.mAdapterMenuActivity.changeTitlePizzaActivity(position);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private AdapterMenuActivity mAdapterMenuActivity;

        public MyViewHolder(View itemView, AdapterMenuActivity mAdapterMenuActivity) {
            super(itemView);
            button = itemView.findViewById(R.id.pizzaButton);
            this.mAdapterMenuActivity = mAdapterMenuActivity;
        }
    }

    private void changeTitlePizzaActivity(int i) {
        selectedItemMenuButton = i;
        notifyDataSetChanged();
    }
}

