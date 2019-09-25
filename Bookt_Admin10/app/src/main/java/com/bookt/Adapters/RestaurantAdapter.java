package com.bookt.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bookt.Modules.Restaurant;
import com.bookt.bookt_admin10.ConfirmActivity;
import com.bookt.bookt_admin10.R;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Restaurant> restaurantArrayList;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurantArrayList) {
        this.context = context;
        this.restaurantArrayList = restaurantArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.restaurant_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // restaurant Info
        holder.restaurant.setText(restaurantArrayList.get(position).getRestaurant_name());
        holder.cuisine.setText(restaurantArrayList.get(position).getRestaurant_cuisine());
        holder.city.setText(restaurantArrayList.get(position).getRestaurant_city());

        // contact info
        holder.name.setText(String.format("%s %s", restaurantArrayList.get(position).getPerson().getFirst_name(), restaurantArrayList.get(position).getPerson().getLast_name()));
        holder.email.setText(restaurantArrayList.get(position).getPerson().getEmail());
        holder.phone.setText(restaurantArrayList.get(position).getPerson().getMobile_number());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ConfirmActivity.class);
                intent.putExtra("Restaurant",restaurantArrayList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView restaurant;
        TextView cuisine;
        TextView city;
        TextView name;
        TextView email;
        TextView phone;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);
            restaurant = itemView.findViewById(R.id.restaurant_name);
            cuisine = itemView.findViewById(R.id.restaurant_cuisine);
            city = itemView.findViewById(R.id.restaurant_city);
            name = itemView.findViewById(R.id.contact_name);
            email = itemView.findViewById(R.id.contact_email);
            phone = itemView.findViewById(R.id.contact_phone);
        }
    }
}
