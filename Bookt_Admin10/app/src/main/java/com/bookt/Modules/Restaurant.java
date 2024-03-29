package com.bookt.Modules;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Restaurant implements Parcelable {
    private String restaurant_city;
    private String restaurant_close;
    private String restaurant_country;
    private String restaurant_cuisine;
    private String restaurant_location;
    private String restaurant_name;
    private String restaurant_open;
    private String restaurant_price;
    private String restaurant_telephone;
    private String restaurant_zip;
    private String sections;
    private String firebase_id;
    private Person person;
    private ArrayList<String> imageList;
    private ArrayList<Menu> menuItems;
    private ArrayList<Table> tableListSingle;
    private ArrayList<Table> tableListFamily;

    public Restaurant() {
    }

    public Restaurant(String restaurant_city, String restaurant_close, String restaurant_country, String restaurant_cuisine, String restaurant_location, String restaurant_name, String restaurant_open, String restaurant_price, String restaurant_telephone, String restaurant_zip, String sections, String firebase_id, Person person, ArrayList<String> imageList, ArrayList<Menu> menuItems, ArrayList<Table> tableListSingle, ArrayList<Table> tableListFamily) {
        this.restaurant_city = restaurant_city;
        this.restaurant_close = restaurant_close;
        this.restaurant_country = restaurant_country;
        this.restaurant_cuisine = restaurant_cuisine;
        this.restaurant_location = restaurant_location;
        this.restaurant_name = restaurant_name;
        this.restaurant_open = restaurant_open;
        this.restaurant_price = restaurant_price;
        this.restaurant_telephone = restaurant_telephone;
        this.restaurant_zip = restaurant_zip;
        this.sections = sections;
        this.firebase_id = firebase_id;
        this.person = person;
        this.imageList = imageList;
        this.menuItems = menuItems;
        this.tableListSingle = tableListSingle;
        this.tableListFamily = tableListFamily;
    }

    protected Restaurant(Parcel in) {
        restaurant_city = in.readString();
        restaurant_close = in.readString();
        restaurant_country = in.readString();
        restaurant_cuisine = in.readString();
        restaurant_location = in.readString();
        restaurant_name = in.readString();
        restaurant_open = in.readString();
        restaurant_price = in.readString();
        restaurant_telephone = in.readString();
        restaurant_zip = in.readString();
        sections = in.readString();
        firebase_id = in.readString();
        person = in.readParcelable(Person.class.getClassLoader());
        imageList = in.createStringArrayList();
        menuItems = in.createTypedArrayList(Menu.CREATOR);
        tableListSingle = in.createTypedArrayList(Table.CREATOR);
        tableListFamily = in.createTypedArrayList(Table.CREATOR);
    }

    public String getRestaurant_city() {
        return restaurant_city;
    }

    public void setRestaurant_city(String restaurant_city) {
        this.restaurant_city = restaurant_city;
    }

    public String getRestaurant_close() {
        return restaurant_close;
    }

    public void setRestaurant_close(String restaurant_close) {
        this.restaurant_close = restaurant_close;
    }

    public String getRestaurant_country() {
        return restaurant_country;
    }

    public void setRestaurant_country(String restaurant_country) {
        this.restaurant_country = restaurant_country;
    }

    public String getRestaurant_cuisine() {
        return restaurant_cuisine;
    }

    public void setRestaurant_cuisine(String restaurant_cuisine) {
        this.restaurant_cuisine = restaurant_cuisine;
    }

    public String getRestaurant_location() {
        return restaurant_location;
    }

    public void setRestaurant_location(String restaurant_location) {
        this.restaurant_location = restaurant_location;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_open() {
        return restaurant_open;
    }

    public void setRestaurant_open(String restaurant_open) {
        this.restaurant_open = restaurant_open;
    }

    public String getRestaurant_price() {
        return restaurant_price;
    }

    public void setRestaurant_price(String restaurant_price) {
        this.restaurant_price = restaurant_price;
    }

    public String getRestaurant_telephone() {
        return restaurant_telephone;
    }

    public void setRestaurant_telephone(String restaurant_telephone) {
        this.restaurant_telephone = restaurant_telephone;
    }

    public String getRestaurant_zip() {
        return restaurant_zip;
    }

    public void setRestaurant_zip(String restaurant_zip) {
        this.restaurant_zip = restaurant_zip;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getFirebase_id() {
        return firebase_id;
    }

    public void setFirebase_id(String firebase_id) {
        this.firebase_id = firebase_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public ArrayList<Menu> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<Menu> menuItems) {
        this.menuItems = menuItems;
    }

    public ArrayList<Table> getTableListSingle() {
        return tableListSingle;
    }

    public void setTableListSingle(ArrayList<Table> tableListSingle) {
        this.tableListSingle = tableListSingle;
    }

    public ArrayList<Table> getTableListFamily() {
        return tableListFamily;
    }

    public void setTableListFamily(ArrayList<Table> tableListFamily) {
        this.tableListFamily = tableListFamily;
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(restaurant_city);
        dest.writeString(restaurant_close);
        dest.writeString(restaurant_country);
        dest.writeString(restaurant_cuisine);
        dest.writeString(restaurant_location);
        dest.writeString(restaurant_name);
        dest.writeString(restaurant_open);
        dest.writeString(restaurant_price);
        dest.writeString(restaurant_telephone);
        dest.writeString(restaurant_zip);
        dest.writeString(sections);
        dest.writeString(firebase_id);
        dest.writeParcelable(person, flags);
        dest.writeStringList(imageList);
        dest.writeTypedList(menuItems);
        dest.writeTypedList(tableListSingle);
        dest.writeTypedList(tableListFamily);
    }
}

