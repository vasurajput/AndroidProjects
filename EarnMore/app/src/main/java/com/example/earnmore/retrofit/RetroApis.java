package com.example.earnmore.retrofit;

import com.example.earnmore.model.PaytmSuccessTransactionResponse;
import com.example.earnmore.model.PaytmToken;
import com.example.earnmore.model.PaytmTokenResponse;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetroApis {
    String BASE_URL = "http://192.168.1.4:8080/";

    @POST("getToken")
    Call<JsonObject> getPostData(@Body PaytmToken body);

    @POST("savePaytmSuccess")
    Call<JsonObject> saveTransactionSuccessResponse(@Body PaytmSuccessTransactionResponse body);
}
