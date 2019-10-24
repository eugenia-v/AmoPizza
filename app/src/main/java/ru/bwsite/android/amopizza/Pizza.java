package ru.bwsite.android.amopizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    String title;
    int imageResourceID;
    String description;
    String[] price_size = new String[4];
    //String gr_name;

    /*public Pizza(String title, int imageResourceID, String description, String[] price_size) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.price_size = price_size;
    }*/
    public Pizza(String title, int imageResourceID, String description, String[] price_size) {
        this.title = title;
        this.imageResourceID = imageResourceID;
        this.description = description;
        this.price_size = price_size;
    }
}
