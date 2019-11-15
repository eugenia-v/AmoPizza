package ru.bwsite.android.amopizza.PizzaActivity;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

import static android.view.View.GONE;

public class AdapterPizzaButtons extends RecyclerView.Adapter<AdapterPizzaButtons.MyViewHolder> {
    private List<SizePrice> size_price;
    private Context context;
    private RecyclerView mRecyclerView;
    private static final int VIEW_ORDINARY = 0;
    private static final int VIEW_WITH_PRICE_TEXT = 1;

    public AdapterPizzaButtons(List<SizePrice> size_price, Context context, RecyclerView recyclerView) {
        this.size_price = size_price;
        this.context = context;
        this.mRecyclerView = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdapterPizzaButtons.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        if (viewType == VIEW_WITH_PRICE_TEXT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pizza_price, parent, false);
            return new PriceTextHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pizza_buttons, parent, false);

            return new AdapterPizzaButtons.MyViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if (position == position % 2) {
            return VIEW_ORDINARY;
        } else {
            return VIEW_WITH_PRICE_TEXT;
        }

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final AdapterPizzaButtons.MyViewHolder holder, final int position) {
        Log.d("position", String.valueOf(position));

        /*holder.button.setText(size_price.get(position).getSize());
        int width = mRecyclerView.getMeasuredWidth();
        holder.button.setLayoutParams(new LinearLayout.LayoutParams(width / size_price.size(), 70));
        if (size_price.get(position).getSize() != null && position == 0) {
            holder.button.setBackgroundResource(R.drawable.bgalt);
        }*/
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        Log.d("size", point.toString());
        int pixel = point.x;
        Log.d("size", String.valueOf(pixel));
        int width = pixel - (80 * (int) context.getResources().getDisplayMetrics().density);
        Log.d("size", String.valueOf(width));
        if (holder.getItemViewType() == VIEW_ORDINARY) {
            ((MyViewHolder) holder).bindSize(size_price.get(position), width, size_price.size(), position);
        } else {
            ((PriceTextHolder) holder).bindPrice(size_price.get(position), width, size_price.size(), position);
        }

    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return size_price.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private Button button;
        private LinearLayout linearLayout;
        private TextView priceText;
        private ImageView rub_image;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            linearLayout = itemView.findViewById(R.id.buttons);

        }

        public void bindSize(SizePrice size_price, int width, int buttonsCount, int position) {
            button.setText(size_price.getSize());
            button.setLayoutParams(new LinearLayout.LayoutParams(width / buttonsCount, 70));
            if (size_price.getSize() != null && position == 0) {
                button.setBackgroundResource(R.drawable.bgalt);
            }
            if (size_price.getSize() == null) {
                button.setVisibility(View.GONE);
            }
        }
    }
}
