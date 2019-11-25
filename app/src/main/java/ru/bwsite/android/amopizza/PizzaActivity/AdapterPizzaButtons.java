package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.SizePrice;
import ru.bwsite.android.amopizza.R;

public class AdapterPizzaButtons extends RecyclerView.Adapter<AdapterPizzaButtons.MyViewHolder> {
    private List<SizePrice> size_price;
    private Context context;
    private AdapterPizzaActivity.MyViewHolder mAdapterPizzaActivityMyViewHolder;
    private int selectedItem = 0;

    public AdapterPizzaButtons(List<SizePrice> size_price, Context context, RecyclerView recyclerView, AdapterPizzaActivity.MyViewHolder mAdapterPizzaActivityMyViewHolder) {
        this.size_price = size_price;
        this.context = context;
        this.mAdapterPizzaActivityMyViewHolder = mAdapterPizzaActivityMyViewHolder;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPizzaButtons.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_buttons, parent, false);

        return new AdapterPizzaButtons.MyViewHolder(view, this);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final AdapterPizzaButtons.MyViewHolder holder, final int position) {
        Log.d("position", String.valueOf(position));

        int width = screenSizePx() - dpToPx(96);//96 - отступ кнопок от края экрана
        holder.bindSize(size_price.get(position), width, size_price.size(), position, mAdapterPizzaActivityMyViewHolder);
        if (position == selectedItem) {
            holder.button.setBackgroundResource(R.drawable.shadow_blue_button);
        } else
            holder.button.setBackgroundResource(R.drawable.shadow_gray_button);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return size_price.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        private LinearLayout linearLayout;
        private AdapterPizzaButtons adapterPizzaButtons;

        public MyViewHolder(View itemView, AdapterPizzaButtons adapterPizzaButtons) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            linearLayout = itemView.findViewById(R.id.buttons);
            this.adapterPizzaButtons = adapterPizzaButtons;
        }

        public void bindSize(final SizePrice size_price, int width, int buttonsCount, final int position, final AdapterPizzaActivity.MyViewHolder mAdapterPizzaActivityMyViewHolder) {
            button.setText(size_price.getSize());
            button.setLayoutParams(new LinearLayout.LayoutParams(width / buttonsCount, 70));
            if (size_price.getSize() == null) {
                button.setVisibility(View.GONE);
            }

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mAdapterPizzaActivityMyViewHolder.setPriceString(size_price.getPrice());
                    adapterPizzaButtons.changeColor(position);
                }
            });
        }
    }

    private void changeColor(int i) {
        selectedItem = i;
        notifyDataSetChanged();
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int screenSizePx() {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }
}
