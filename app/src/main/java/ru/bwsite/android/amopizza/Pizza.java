package ru.bwsite.android.amopizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    String title;
    String link;
    String description;
    String images;
    //String price;
    //String guid;

    public Pizza(String title, String link, String description, String images){
        this.title = title;
        this.link = link;
        this.description = description;
        this.images = images;
    }
}
