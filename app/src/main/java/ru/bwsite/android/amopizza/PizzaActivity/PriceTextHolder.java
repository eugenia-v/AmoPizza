package ru.bwsite.android.amopizza.PizzaActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.bwsite.android.amopizza.DataObjects.SizePrice;
import ru.bwsite.android.amopizza.R;

public class PriceTextHolder extends AdapterPizzaButtons.MyViewHolder {
    private TextView priceText;
    private ImageView rub_image;

    public PriceTextHolder(View itemView) {
        super(itemView);
        priceText = itemView.findViewById(R.id.price);
        rub_image = itemView.findViewById(R.id.rub_image);
    }
    public void bindPrice(SizePrice size_price, int width, int buttonsCount, int position) {
        if (size_price.getSize() != null && position == 0) {
            priceText.setText(size_price.getPrice());
            Log.d("buttons", size_price.getPrice());
        }
        if (size_price.getSize() == null) {
            rub_image.setVisibility(View.GONE);
        }
    }
}
