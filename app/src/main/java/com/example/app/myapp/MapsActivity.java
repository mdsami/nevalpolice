package com.example.app.myapp;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Context mContext;
    private Activity mActivity;


    LatLng location;
    private double lat1;
    private double long1;
    private String mJSONURLString = "http://etutorsfinder.com/thanafari.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Get the application context
        mContext = getApplicationContext();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


// Initialize a new RequestQueue instance
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        // Initialize a new JsonObjectRequest instance
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                mJSONURLString,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Do something with response
                        //mTextView.setText(response.toString());
                        Log.e("response",response.toString());

                        // Process the JSON
                        try{
                            // Get the JSON array
                            JSONArray array = response.getJSONArray("thanafari");

                            // Loop through the array elements
                            for(int i=0;i<array.length();i++){
                                // Get current json object
                                JSONObject thanafari = array.getJSONObject(i);

                                // Get the current student (json object) data
                                String oc = thanafari.getString("oc");
                                String name = thanafari.getString("name");
                                String phone = thanafari.getString("phone");
                                String lat = thanafari.getString("lat");
                                String lon = thanafari.getString("long");

                                Log.e("lat - long", lat+"->"+lon);
                                // Display the formatted json data in text view
                                lat1 = Double.parseDouble(lat);
                                long1 = Double.parseDouble(lon);

                                location = new LatLng(lat1, long1);

//                                mMap.clear();

                                mMap.addMarker(new MarkerOptions()
                                        .position(location)
                                        .title(oc)

                                        .snippet("Thana / Fari name: " + name)
                                        .icon(BitmapDescriptorFactory
                                                .fromResource(R.drawable.pin)));

                                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                    @Override
                                    public void onInfoWindowClick(Marker marker) {
                                        Intent intent = new Intent(MapsActivity.this, ComplainActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }

                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
                            mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 2000, null);

                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred

                    }
                }

        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }
        };

        // Add JsonObjectRequest to the RequestQueue
        requestQueue.add(jsonObjectRequest);





    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Intent conplainIntent = new Intent(mContext,ComplainActivity.class);
//                mContext.startActivity(conplainIntent);
//            }
//        });


        // Add a marker in Office of DIG River Police and move the camera
        LatLng dhaka = new LatLng(23.7942978, 90.3528592);
        mMap.addMarker(new MarkerOptions().position(dhaka).title("ডিআইজি নদী পুলিশ অফিস"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dhaka,10.2f));
    }
}
