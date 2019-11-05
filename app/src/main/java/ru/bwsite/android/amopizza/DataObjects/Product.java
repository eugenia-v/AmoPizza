package ru.bwsite.android.amopizza.DataObjects;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ru.bwsite.android.amopizza.DataObjects.SizePrice;

public class Product {
    int id;
    String name;
    String img_url;
    String desc;
    String label_text;
    String label_color;
    List<SizePrice> size_price;

    public Product(int id, String name, String img_url, String desc, String label_text, String label_color, List<SizePrice> size_price) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.desc = desc;
        this.label_text = label_text;
        this.label_color = label_color;
        this.size_price = size_price;
    }
}
