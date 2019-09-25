package com.bookt.bookt_admin10;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bookt.Adapters.RestaurantAdapter;
import com.bookt.Modules.Restaurant;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;
    ArrayList<Restaurant> restaurantArrayList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Restaurants :0");

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {

                            return;
                        }
                        // Get the Instance ID token//
                        String token = task.getResult().getToken();
                        String msg = getString(R.string.fcm_token, token);
                        Log.d("TAG", msg);

                    }
                });


        recyclerView = findViewById(R.id.restaurant_recycler_view);
        restaurantArrayList = new ArrayList<>();
        restaurantAdapter = new RestaurantAdapter(this,restaurantArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(restaurantAdapter);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("QueueList");





        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Restaurant restaurant = dataSnapshot.getValue(Restaurant.class);
                    restaurantArrayList.add(0,restaurant);
                restaurantAdapter.notifyDataSetChanged();
                setTitle("Restaurants: "+restaurantArrayList.size());

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    Restaurant restaurant = dataSnapshot.getValue(Restaurant.class);
                    for(int i=0;i<restaurantArrayList.size();i++){
                        if (restaurant != null && restaurant.getFirebase_id().equals(restaurantArrayList.get(i).getFirebase_id())) {
                            restaurantArrayList.set(i, restaurant);
                            break;
                        }
                    }
                restaurantAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    Restaurant restaurant = dataSnapshot.getValue(Restaurant.class);
                    for(int i=0;i<restaurantArrayList.size();i++){
                        if (restaurant != null  && restaurant.getFirebase_id().equals(restaurantArrayList.get(i).getFirebase_id())) {
                            restaurantArrayList.remove(i);
                            break;
                        }
                    }
                restaurantAdapter.notifyDataSetChanged();
                setTitle("Restaurants :"+restaurantArrayList.size());

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }
}
