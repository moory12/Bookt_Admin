package com.bookt.Modules;

import android.os.Parcel;
import android.os.Parcelable;

public class Image implements Parcelable {

    private String image;

    public Image() {
    }

    public Image(String image) {
        this.image = image;
    }

    protected Image(Parcel in) {
        image = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
    }
}
