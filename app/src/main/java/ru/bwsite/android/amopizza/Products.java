package ru.bwsite.android.amopizza;

import java.util.ArrayList;
import java.util.List;

public class Products {
    String gr_name;
    String title;
    int imageResourceID;
    String description;
    String[] price_size = new String[4];

    public Products(String gr_name, String title, int imageResourceID, String description, String[] price_size) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.price_size = price_size;
        this.gr_name = gr_name;
    }
}
