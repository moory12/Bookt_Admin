package com.bookt.bookt_admin10;


import android.support.v4.app.FragmentManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bookt.Adapters.ImageAdapter;
import com.bookt.Adapters.MenuAdapter;
import com.bookt.Modules.Image;
import com.bookt.Modules.Item;
import com.bookt.Modules.Rest;
import com.bookt.Modules.Restaurant;
import com.bookt.Modules.RestaurantDetails;
import com.bookt.Modules.Type;
import com.google.android.gms.maps.MapView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ConfirmActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    TextView confirm;
    Restaurant restaurant;
    ArrayList<Image> imageArrayList;
    RecyclerView recyclerImages;
    RecyclerView recyclerMenu;
    ImageAdapter imageAdapter;
    MenuAdapter menuAdapter;
    ArrayList<Type> types;
    ArrayList<Item> items;
    ArrayList<String> stringArrayList;
    TextView personName;
    TextView personNumber;
    TextView personEmail;
    TextView rName;
    TextView rCountry;
    TextView rCity;
    TextView rZipCode;
    TextView rCuisine;
    TextView ropen;
    TextView rClose;
    TextView dollar1,dollar2,dollar3,dollar4,dollar5;
    TextView rSection;
    TextView rNumber;
    NestedScrollView nestedScrollView;
    MapView mapView;
    static String location;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        imageArrayList  = new ArrayList<>();
        stringArrayList = new ArrayList<>();
        types           = new ArrayList<>();
        items           = new ArrayList<>();
        imageArrayList  = new ArrayList<>();




        confirm        = findViewById(R.id.confirm);
        recyclerImages = findViewById(R.id.recyclerView_images);
        recyclerMenu   = findViewById(R.id.recyclerView_menu);
        personName     = findViewById(R.id.person_name);
        personNumber   = findViewById(R.id.person_phone_number);
        personEmail    = findViewById(R.id.person_email);
        rName          = findViewById(R.id.r_name);
        rCountry       = findViewById(R.id.r_country);
        rCity          = findViewById(R.id.r_city);
        rZipCode       = findViewById(R.id.r_zip_code);
        rCuisine       = findViewById(R.id.r_cuisine);
        ropen          = findViewById(R.id.r_open);
        rClose         = findViewById(R.id.r_close);
        dollar1        = findViewById(R.id.dollar1);
        dollar2        = findViewById(R.id.dollar2);
        dollar3        = findViewById(R.id.dollar3);
        dollar4        = findViewById(R.id.dollar4);
        dollar5        = findViewById(R.id.dollar5);
        rSection       = findViewById(R.id.r_section);
        rNumber        = findViewById(R.id.r_phone_number);
        mapView        = findViewById(R.id.mapView);
        nestedScrollView = findViewById(R.id.nsv);
        nestedScrollView.setSmoothScrollingEnabled(false);





        restaurant= getIntent().getParcelableExtra("Restaurant");

        if(restaurant.getMenuItems()!=null) {
            for (int i = 0; i < restaurant.getMenuItems().size(); i++) {
                ArrayList<Item> itemArrayList = new ArrayList<>();
                if(restaurant.getMenuItems().get(i).getMenuItems() !=null) {
                    for (int j = 0; j < restaurant.getMenuItems().get(i).getMenuItems().size(); j++) {
                        String image = restaurant.getMenuItems().get(i).getMenuItems().get(j).getImage();
                        String price = restaurant.getMenuItems().get(i).getMenuItems().get(j).getPrice();
                        String title = restaurant.getMenuItems().get(i).getMenuItems().get(j).getName();
                        String subtite = restaurant.getMenuItems().get(i).getMenuItems().get(j).getDescription();
                        Item item = new Item(title, subtite, price, image);
                        itemArrayList.add(item);
                        items.add(item);
                    }
                }
                Type type = new Type(restaurant.getMenuItems().get(i).getMenuCategory(), itemArrayList);
                types.add(type);
            }
        }

        stringArrayList.addAll(restaurant.getImageList());
        personName.setText(restaurant.getPerson().getFirst_name()+" "+restaurant.getPerson().getLast_name());
        personEmail.setText(restaurant.getPerson().getEmail());
        personNumber.setText(restaurant.getPerson().getMobile_number());
        rName.setText(restaurant.getRestaurant_name());
        rCountry.setText(restaurant.getRestaurant_country());
        rCity.setText(restaurant.getRestaurant_city());
        rZipCode.setText(restaurant.getRestaurant_zip());
        rSection.setText(restaurant.getSections());
        ropen.setText(restaurant.getRestaurant_open());
        rClose.setText(restaurant.getRestaurant_close());
        rNumber.setText(restaurant.getRestaurant_telephone());

        String p = restaurant.getRestaurant_price();
        if(p.equals("cheap")){
            dollar5.setTextColor(getResources().getColor(android.R.color.white));
            dollar4.setTextColor(getResources().getColor(android.R.color.white));
            dollar3.setTextColor(getResources().getColor(android.R.color.white));
            dollar2.setTextColor(getResources().getColor(android.R.color.white));
        }
        else if(p.equals("semi-moderate")){
            dollar5.setTextColor(getResources().getColor(android.R.color.white));
            dollar4.setTextColor(getResources().getColor(android.R.color.white));
            dollar3.setTextColor(getResources().getColor(android.R.color.white));
        }
        else if(p.equals("moderate")){
            dollar5.setTextColor(getResources().getColor(android.R.color.white));
            dollar4.setTextColor(getResources().getColor(android.R.color.white));
        }
        else if(p.equals("semi-expensive")){
            dollar5.setTextColor(getResources().getColor(android.R.color.white));

        }




        location = restaurant.getRestaurant_location();

        if(restaurant.getMenuItems()!=null) {
            menuAdapter  = new MenuAdapter(types,this,types,items);
            recyclerMenu.setLayoutManager(new LinearLayoutManager(this));
            recyclerMenu.setAdapter(menuAdapter);
        }
        imageAdapter = new ImageAdapter(this,stringArrayList);
        recyclerImages.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerImages.setAdapter(imageAdapter);



        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Restaurants").child(restaurant.getFirebase_id());

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestaurantDetails restaurantDetails = new RestaurantDetails(restaurant.getRestaurant_city()
                        , restaurant.getRestaurant_close()
                        , restaurant.getRestaurant_country()
                        , restaurant.getRestaurant_cuisine()
                        , restaurant.getRestaurant_location()
                        , restaurant.getRestaurant_name()
                        , restaurant.getRestaurant_open()
                        , restaurant.getRestaurant_price()
                        , restaurant.getRestaurant_telephone()
                        , restaurant.getRestaurant_zip()
                        , restaurant.getSections()
                        , restaurant.getFirebase_id()
                );
                if (restaurant.getImageList() != null) {
                    for (int i = 0; i < restaurant.getImageList().size(); i++) {
                        imageArrayList.add(new Image(restaurant.getImageList().get(i)));
                    }
                }
                Rest rest = new Rest(restaurantDetails, restaurant.getPerson(), imageArrayList, restaurant.getMenuItems(), restaurant.getTableListSingle(), restaurant.getTableListFamily());
                reference.setValue(rest);


                    reference = database.getReference().child("QueueList").child(restaurant.getFirebase_id());
                    reference.removeValue();
                    finish();
                }

        });


        FragmentManager fragmentManager = getSupportFragmentManager();

        MapFragment mapFragment = new MapFragment();

        fragmentManager.beginTransaction().add(R.id.mapView,mapFragment).commit();













    }




}
