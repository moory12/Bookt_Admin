package com.bookt.Modules;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Rest implements Parcelable {

    private RestaurantDetails restaurantDetails;
    private Person person;
    private ArrayList<Image> imageList;
    private ArrayList<Menu> menuItems;
    private ArrayList<Table> tableListSingle;
    private ArrayList<Table> tableListFamily;

    public Rest() {
    }

    public Rest(RestaurantDetails restaurantDetails, Person person, ArrayList<Image> imageList, ArrayList<Menu> menuItems, ArrayList<Table> tableListSingle, ArrayList<Table> tableListFamily) {
        this.restaurantDetails = restaurantDetails;
        this.person = person;
        this.imageList = imageList;
        this.menuItems = menuItems;
        this.tableListSingle = tableListSingle;
        this.tableListFamily = tableListFamily;
    }

    protected Rest(Parcel in) {
        restaurantDetails = in.readParcelable(RestaurantDetails.class.getClassLoader());
        person = in.readParcelable(Person.class.getClassLoader());
        imageList = in.createTypedArrayList(Image.CREATOR);
        menuItems = in.createTypedArrayList(Menu.CREATOR);
        tableListSingle = in.createTypedArrayList(Table.CREATOR);
        tableListFamily = in.createTypedArrayList(Table.CREATOR);
    }

    public static final Creator<Rest> CREATOR = new Creator<Rest>() {
        @Override
        public Rest createFromParcel(Parcel in) {
            return new Rest(in);
        }

        @Override
        public Rest[] newArray(int size) {
            return new Rest[size];
        }
    };

    public RestaurantDetails getRestaurantDetails() {
        return restaurantDetails;
    }

    public void setRestaurantDetails(RestaurantDetails restaurantDetails) {
        this.restaurantDetails = restaurantDetails;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
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

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(restaurantDetails, flags);
        dest.writeParcelable(person, flags);
        dest.writeTypedList(imageList);
        dest.writeTypedList(menuItems);
        dest.writeTypedList(tableListSingle);
        dest.writeTypedList(tableListFamily);
    }
}
