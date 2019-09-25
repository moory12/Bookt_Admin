package com.bookt.Adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookt.Modules.Item;
import com.bookt.Modules.Type;
import com.bookt.bookt_admin10.R;
import com.bumptech.glide.Glide;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends ExpandableRecyclerViewAdapter<MenuAdapter.TypeHolder, MenuAdapter.ItemsHolder> {

    private Context context;
    private ArrayList<Type> typeArrayList;
    private ArrayList<Item> itemArrayList;



    public MenuAdapter(List<? extends ExpandableGroup> groups, Context context, ArrayList<Type> typeArrayList, ArrayList<Item> itemArrayList) {
        super(groups);
        this.context = context;
        this.typeArrayList = typeArrayList;
        this.itemArrayList = itemArrayList;
    }




    @Override
    public TypeHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_cardview, parent, false);
        return new TypeHolder(view);
    }

    @Override
    public ItemsHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new ItemsHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ItemsHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        System.out.println(itemArrayList.size());
        Glide.with(context).load(itemArrayList.get(childIndex).getImage()).into(holder.itemImage);
        holder.title.setText(itemArrayList.get(childIndex).getTitle());
        holder.subtitle.setText(itemArrayList.get(childIndex).getSubTitle());
        holder.itemPrice.setText(itemArrayList.get(childIndex).getPrice());

    }

    @Override
    public void onBindGroupViewHolder(final TypeHolder holder, int flatPosition, ExpandableGroup group) {
            holder.menuType.setText(typeArrayList.get(flatPosition).getTitle());
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public class TypeHolder extends GroupViewHolder{
        ConstraintLayout constraintLayout;
        ImageView imageView;
        TextView menuType;

        public TypeHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.drop_icon);
            menuType  = itemView.findViewById(R.id.menu_type);
            constraintLayout = itemView.findViewById(R.id.type_layout);
        }


        @Override
        public void expand() {
            super.expand();
            imageView.setImageResource(R.drawable.ic_arrow_drop_up_white_24dp);
        }

        @Override
        public void collapse() {
            super.collapse();
            imageView.setImageResource(R.drawable.ic_arrow_drop_down_white_24dp);
        }
    }

    public class ItemsHolder extends ChildViewHolder{

        ImageView itemImage;
        TextView  title;
        TextView  subtitle;
        TextView  itemPrice;
        public ItemsHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            title     = itemView.findViewById(R.id.item_title);
            subtitle  = itemView.findViewById(R.id.r_close);
            itemPrice = itemView.findViewById(R.id.item_price);

        }
    }
}
