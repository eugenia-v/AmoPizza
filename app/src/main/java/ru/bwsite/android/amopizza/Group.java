package ru.bwsite.android.amopizza;

import java.util.List;

public class Group {
    String gr_name;
    List<Product> products;

    public Group(String gr_name, List<Product> products) {
        this.gr_name = gr_name;
        this.products = products;
    }
}
