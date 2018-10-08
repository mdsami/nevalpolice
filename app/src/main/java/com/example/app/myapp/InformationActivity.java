package com.example.app.myapp;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app.myapp.adapter.ThanaFariListAdapter;
import com.example.app.myapp.adapter.ThanaFariRecyclerAdapter;
import com.example.app.myapp.model.Information;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

//    private static final String JSON_URL = "http://34.229.163.255/~bnpdb/thanafari.json";

    private static final String JSON_URL = "http://hostbrine.net/thanafari.json";
    private List<Information> informationList;
    private ThanaFariRecyclerAdapter thanaFariRecyclerAdapter;
    private RecyclerView recyclerViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        informationList = new ArrayList<>();
        thanaFariRecyclerAdapter = new ThanaFariRecyclerAdapter(informationList);
        recyclerViewInfo = findViewById(R.id.recyclerViewInfo);
        recyclerViewInfo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewInfo.setAdapter(thanaFariRecyclerAdapter);

        loadthanafariList();


    }

    private void loadthanafariList() {
        //getting the progressbar

        //making the progressbar visible


        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);

                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray thanaArray = obj.getJSONArray("thanafari");

                            //now looping through all the elements of the json array
                            for (int i = 0; i < thanaArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject thanaObject = thanaArray.getJSONObject(i);

                                //creating a hero object and giving them the values from json object
                                //ThanaFariList  thanaFariList = new ThanaFariList (heroObject.getString("oc"), heroObject.getString("name"), heroObject.getString("phone"));
                                Information information = new Information(thanaObject.getString("oc"),thanaObject.getString("name"),thanaObject.getString("phone"));

                                //adding the hero to herolist
                                informationList.add(information);
                                thanaFariRecyclerAdapter.notifyDataSetChanged();
                            }

                            //creating custom adapter object

                            //adding the adapter to listview


                            //listView.setTypeface(fontStyleBangla);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
}
