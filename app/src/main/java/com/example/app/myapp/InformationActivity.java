package com.example.app.myapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.example.app.myapp.module.SpinnerValue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InformationActivity extends AppCompatActivity {

//    private static final String JSON_URL = "http://34.229.163.255/~bnpdb/thanafari.json";



    SpinnerValue[] spArr1 = new SpinnerValue[]{

            new SpinnerValue("Select Thana ", "0"),
            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
            new SpinnerValue("নারায়ণগঞ্জ সদর নৌ থানা", "59"),
            new SpinnerValue("কলাগছিয়া নৌ থানা", "60"),
            new SpinnerValue("পাটুরিয়া নৌ থানা", "87"),
            new SpinnerValue("ডবাহাদুরবাদ নৌ থানা", "93"),
            new SpinnerValue("বরিশাল সদর নৌ থানা", "103"),
            new SpinnerValue("পূর্ব ইলিশা নৌ থানা ", "104"),
            new SpinnerValue("হকেএমপি নৌ থানা খুলনা", "116"),
            new SpinnerValue("নলিয়ান নৌ থানা", "117"),
            new SpinnerValue("চাঁদপাই নৌ থানা", "118"),
            new SpinnerValue("বুড়ি গোয়ালিনী নৌ থানা", "119"),
            new SpinnerValue("চাঁঁদপুর সদর নৌ থানা", "135"),




    };

    SpinnerValue[] spArr2 = new SpinnerValue[]{
            new SpinnerValue("Select Fari ", "0"),
            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়ি ", "1"),
            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "2")

            //            new SpinnerValue("সদরঘাট নৌ থানা ", "58"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "59"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "60"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "61"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "62"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "63"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "64"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "55"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "66"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "66"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "67"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "68"),
//
//            new SpinnerValue("সদরঘাট নৌ থানা ", "69"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "70"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "71"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "72"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "73"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "74"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "75"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "76"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "77"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "78"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "79"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "80"),
//
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//
//
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//
//
//
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//
//
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),
//            new SpinnerValue("সদরঘাট নৌ থানা ", "52"),
//            new SpinnerValue("হাসনাবাদ নৌ ফাঁড়", "53"),
//            new SpinnerValue("কুতুবপুর নৌ ফাঁড়", "54"),
//            new SpinnerValue("বরিসুর নৌ ফাঁড়", "55"),
//            new SpinnerValue("ডেমরা নৌ ফাঁড়ি", "56"),
//            new SpinnerValue("বসিলা নৌ ফাঁড়ি", "57"),

    };


    private static final String JSON_URL = "http://etutorsfinder.com/thanafari.json";
    private List<Information> informationList;
    private ThanaFariRecyclerAdapter thanaFariRecyclerAdapter;
    private RecyclerView recyclerViewInfo;
    IdInitialClass idInitialClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
       // onBackPressed();



        informationList = new ArrayList<>();
        thanaFariRecyclerAdapter = new ThanaFariRecyclerAdapter(informationList);
        recyclerViewInfo = findViewById(R.id.recyclerViewInfo);
        recyclerViewInfo.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewInfo.setAdapter(thanaFariRecyclerAdapter);
        this.recyclerViewInfo.requestFocus();


        loadthanafariList();


        //setup data
        idInitialClass = new IdInitialClass();

        //initialize Spinner
        for (int i = 1; i <= 3; i++) {
            if ( i == 1 ) {
                idInitialClass.getSpinner(this, "sp" + i, spArr1);
            }else if(i == 2){

                idInitialClass.getSpinner(this, "sp" + i, spArr2);

            }



        }


        Button button= (Button) findViewById(R.id.backarrow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



    }

//    @Override
//    public void onBackPressed() {
//        finish();
//    }

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
