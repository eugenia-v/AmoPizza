package ru.bwsite.android.amopizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Products {
    String gr_name;
    String title;
    int imageResourceID;
    String description;
    ArrayList<String> price;
    ArrayList<String> size;

    public Products(String title) {
        this.title = title;
    }

    public Products(String gr_name, String title, int imageResourceID, String description, ArrayList<String> price, ArrayList<String> size) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.price = price;
        this.size = size;
        this.gr_name = gr_name;
    }

}
