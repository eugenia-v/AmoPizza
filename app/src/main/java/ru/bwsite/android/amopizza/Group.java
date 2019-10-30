package ru.bwsite.android.amopizza;

public class Group {
    String gr_name;
    Product[] products;

    public Group(String gr_name, Product[] products) {
        this.gr_name = gr_name;
        this.products = products;
    }
}
