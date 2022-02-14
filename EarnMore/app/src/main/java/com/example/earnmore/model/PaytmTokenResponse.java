package com.example.earnmore.model;

import java.util.Map;

public class PaytmTokenResponse {

    Map<String, Object> paytmResponse;

    public PaytmTokenResponse() {
    }

    public PaytmTokenResponse(Map<String, Object> paytmResponse) {
        this.paytmResponse = paytmResponse;
    }

    public Map<String, Object> getPaytmResponse() {
        return paytmResponse;
    }

    public void setPaytmResponse(Map<String, Object> paytmResponse) {
        this.paytmResponse = paytmResponse;
    }
}
