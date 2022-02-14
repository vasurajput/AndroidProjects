package com.example.earnmore.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitClient {
    private static MyRetrofitClient myRetrofitClient = null;
    private static RetroApis myRetroApis;

    private MyRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(myRetroApis.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myRetroApis = retrofit.create(RetroApis.class);
    }

    public static MyRetrofitClient getInstance() {
        if (myRetrofitClient == null) {
            synchronized (MyRetrofitClient.class) {
                if (myRetrofitClient == null) {
                    myRetrofitClient = new MyRetrofitClient();
                }
            }
        }
        return myRetrofitClient;
    }

    public RetroApis getMyApi() {
        return myRetroApis;
    }
}
