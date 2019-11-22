package ru.bwsite.android.amopizza.MenuActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.GroupProduct;
import ru.bwsite.android.amopizza.PizzaActivity.PizzaActivity;
import ru.bwsite.android.amopizza.R;
import ru.bwsite.android.amopizza.DataObjects.Product;

public class AdapterMenuActivity extends RecyclerView.Adapter<AdapterMenuActivity.MyViewHolder> {

    private List<GroupProduct> groupList;
    private MenuActivity context;

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
                .inflate(R.layout.item_button, parent, false);

        return new AdapterMenuActivity.MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final AdapterMenuActivity.MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.button.setText(groupList.get(position).gr_name);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //holder.button_menu.setBackgroundResource(R.drawable.bgalt);
                //Intent intent = new Intent(context, PizzaActivity.class);
                List <Product> productsList = groupList.get(position).products;
                Intent intent = PizzaActivity.newIntent(context, (ArrayList) productsList);
                context.startActivity(intent);
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

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.pizzaButton);
        }
    }
}

