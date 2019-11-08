package ru.bwsite.android.amopizza.PizzaActivity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import ru.bwsite.android.amopizza.R;

public class PizzaButtonsHolder extends AdapterPizzaActivity.MyViewHolder {
    LinearLayout linearLayout;

    public PizzaButtonsHolder(View itemView) {
        super(itemView);
        this.linearLayout = itemView.findViewById(R.id.buttons);
    }
}
