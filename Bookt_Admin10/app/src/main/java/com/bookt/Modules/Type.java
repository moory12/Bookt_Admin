package com.bookt.Modules;

import com.bookt.Modules.Item;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;


public class Type extends ExpandableGroup<Item> {


    public Type(String title, ArrayList<Item> items) {
        super(title, items);
    }



}
