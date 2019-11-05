package ru.bwsite.android.amopizza.DataObjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ru.bwsite.android.amopizza.DataObjects.SizePrice;

public class Product implements Parcelable {
    private int id;
    private String name;
    private String img_url;
    private String desc;
    private String label_text;
    private String label_color;
    private List<SizePrice> size_price;

/*    public Product(int id, String name, String img_url, String desc, String label_text, String label_color, List<SizePrice> size_price) {
        this.id = id;
        this.name = name;
        this.img_url = img_url;
        this.desc = desc;
        this.label_text = label_text;
        this.label_color = label_color;
        this.size_price = size_price;
    }*/


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(img_url);
        dest.writeString(desc);
        dest.writeString(label_text);
        dest.writeString(label_color);
        dest.writeList(size_price);
    }
    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
    private Product(Parcel in) {
        id = in.readInt();
        name = in.readString();
        img_url = in.readString();
        desc = in.readString();
        label_text = in.readString();
        label_color = in.readString();
        in.readList(size_price, ClassLoader.getSystemClassLoader());
    }

    public String getName() {
        return name;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getDesc() {
        return desc;
    }

    public List<SizePrice> getSize_price() {
        return size_price;
    }
}
