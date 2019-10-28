package ru.bwsite.android.amopizza;

import java.util.ArrayList;

public class Product {
    String gr_name;
    String title;
    int imageResourceID;
    String description;
    ArrayList<String> price;
    ArrayList<String> size;

    public Product(String title) {
        this.title = title;
    }

    public Product(String gr_name, String title, int imageResourceID, String description, ArrayList<String> price, ArrayList<String> size) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.price = price;
        this.size = size;
        this.gr_name = gr_name;
    }

}
