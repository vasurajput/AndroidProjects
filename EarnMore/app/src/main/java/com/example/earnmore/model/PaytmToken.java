package com.example.earnmore.model;

public class PaytmToken {

    private String mobileNumber;
    private long orderId;
    private int amount;

    public PaytmToken() {
    }


    public PaytmToken(String mobileNumber, long orderId, int amount) {
        this.mobileNumber = mobileNumber;
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
