package ru.bwsite.android.amopizza.DataObjects;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Parcelable {
    private int id;
    private String name;
    private String img_url;
    private String desc;
    private String label_text;
    private String label_color;
    private List<SizePrice> size_price = new ArrayList<>();

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
        dest.writeTypedList(size_price);
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
        in.readTypedList(size_price, SizePrice.CREATOR);
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
