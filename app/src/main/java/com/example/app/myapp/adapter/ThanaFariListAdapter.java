package com.example.app.myapp.adapter;

import android.content.Context;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.app.myapp.R;
import com.example.app.myapp.ThanaFariList;

import java.util.List;

public class ThanaFariListAdapter extends ArrayAdapter<ThanaFariList> {

    //the hero list that will be displayed
    private List<ThanaFariList> thanafariList;

    //the context object
    private Context mCtx;
    Typeface fontStyleBangla;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ThanaFariListAdapter(List<ThanaFariList> thanafariList, Context mCtx) {
        super(mCtx, R.layout.list_items, thanafariList);
        this.thanafariList = thanafariList;
        this.mCtx = mCtx;
    }


    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.list_items, null, true);

        //getting text views

        //Getting the hero for the specified position
        ThanaFariList thanaFariList = thanafariList.get(position);

        //setting hero values to textviews

        //returning the listitem
        return listViewItem;
    }




















}

