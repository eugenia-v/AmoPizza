package ru.bwsite.android.amopizza.DataObjects;

import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.Product;

public class Group {
    String gr_name;
    List<Product> products;

    public Group(String gr_name, List<Product> products) {
        this.gr_name = gr_name;
        this.products = products;
    }
}
