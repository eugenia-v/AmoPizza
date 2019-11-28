package ru.bwsite.android.amopizza.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SizePrice implements Parcelable {
    private String article;
    private String size;
    private String price;


    public String getArticle() {
        return article;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(article);
        dest.writeString(size);
        dest.writeString(price);
    }

    public static final Parcelable.Creator<SizePrice> CREATOR = new Parcelable.Creator<SizePrice>() {
        public SizePrice createFromParcel(Parcel in) {
            return new SizePrice(in);
        }

        public SizePrice[] newArray(int size) {
            return new SizePrice[size];
        }
    };

    private SizePrice(Parcel in) {
        article = in.readString();
        size = in.readString();
        price = in.readString();
    }
}
