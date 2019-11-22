package ru.bwsite.android.amopizza.DataObjects;

import java.util.List;

import ru.bwsite.android.amopizza.DataObjects.Product;

public class GroupProduct {
    public String gr_name;
    public List<Product> products;

    public GroupProduct(String gr_name, List<Product> products) {
        this.gr_name = gr_name;
        this.products = products;
    }
}
