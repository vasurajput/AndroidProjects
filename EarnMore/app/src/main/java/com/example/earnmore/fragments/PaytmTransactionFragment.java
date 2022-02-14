package com.example.earnmore.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.earnmore.R;
import com.example.earnmore.retrofit.MyRetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;

public class PaytmTransactionFragment extends Fragment {


    public PaytmTransactionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paytm_transaction, container, false);
       // Call<JsonObject> call = MyRetrofitClient.getInstance().getMyApi().getPostData(paytmToken);
        return view;
    }
}