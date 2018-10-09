package com.example.app.myapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl("http://etutorsfinder.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RestApi getRestApiInterface(){
        return getRetrofitClient().create(RestApi.class);
    }
}
