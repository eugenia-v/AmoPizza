package ru.bwsite.android.amopizza.DataObjects;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
    private int mData;
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(mData);
    }
    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
    private MyParcelable(Parcel in) {
        mData = in.readInt();
    }
}
