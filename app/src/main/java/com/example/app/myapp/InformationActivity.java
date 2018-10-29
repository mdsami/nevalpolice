package com.example.app.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
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
            new SpinnerValue("বাহাদুরবাদ নৌ থানা", "93"),
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

    };


    private static final String JSON_URL = "http://etutorsfinder.com/thanafari.json";
    private List<Information> informationList;
    private ThanaFariRecyclerAdapter thanaFariRecyclerAdapter;
    private RecyclerView recyclerViewInfo;
    IdInitialClass idInitialClass;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        // onBackPressed();



        informationList = new ArrayList<>();
        recyclerViewInfo = findViewById(R.id.recyclerViewInfo);
        this.recyclerViewInfo.setNestedScrollingEnabled(false);
        requestQueue = Volley.newRequestQueue(InformationActivity.this);

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

    private void loadthanafariList() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("thanafari");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject thanaList = jsonArray.getJSONObject(i);
                        String oc = thanaList.getString("oc");
                        String name = thanaList.getString("name");
                        String phone = thanaList.getString("phone");
                        String id = thanaList.getString("id");

                        informationList.add(new Information(id,oc,name,phone));

                    }
                    thanaFariRecyclerAdapter = new ThanaFariRecyclerAdapter(informationList);
                    recyclerViewInfo.setLayoutManager(new LinearLayoutManager(InformationActivity.this));
                    recyclerViewInfo.setAdapter(thanaFariRecyclerAdapter);
                    thanaFariRecyclerAdapter.notifyDataSetChanged();

                }catch (JSONException e){
                    Toast.makeText(InformationActivity.this, ""+ e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("ERRRROR",e.getMessage());

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InformationActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ERRRROR",error.getMessage());

            }
        });
        requestQueue.add(request);
    }
}
