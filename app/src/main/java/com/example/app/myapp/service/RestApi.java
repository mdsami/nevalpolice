package com.example.app.myapp.service;

import android.net.Uri;

import com.example.app.myapp.model.Complain;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestApi {


    @GET
    Call<Complain> getComplain(@Url String remainingUrl);


    @POST("complain")
    @Multipart
    Call<Complain> complainPost(@Query("phone") String phone, @Query("message") String message,
                                @Query("thana_id") String thana_id, @Query("fari_id") String fari_id,
                                @Part MultipartBody.Part img,  @Part MultipartBody.Part video, @Part MultipartBody.Part audio);

    // crime_id
    //@Field("crime_id") String crime_id

}
