package com.example.earnmore.model;

public class Offers {
    private String offerName;
    private int offerAmount;
    private String offerDescription;
    private int offerValidityDay;
    private int offerMinUserToAdd;
    private int finalAmountForUser;

    public Offers() {
    }

    public Offers(String offerName, int offerAmount, String offerDescription, int offerValidityDay, int offerMinUserToAdd, int finalAmountForUser) {
        this.offerName = offerName;
        this.offerAmount = offerAmount;
        this.offerDescription = offerDescription;
        this.offerValidityDay = offerValidityDay;
        this.offerMinUserToAdd = offerMinUserToAdd;
        this.finalAmountForUser = finalAmountForUser;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(int offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public int getOfferValidityDay() {
        return offerValidityDay;
    }

    public void setOfferValidityDay(int offerValidityDay) {
        this.offerValidityDay = offerValidityDay;
    }

    public int getOfferMinUserToAdd() {
        return offerMinUserToAdd;
    }

    public void setOfferMinUserToAdd(int offerMinUserToAdd) {
        this.offerMinUserToAdd = offerMinUserToAdd;
    }

    public int getFinalAmountForUser() {
        return finalAmountForUser;
    }

    public void setFinalAmountForUser(int finalAmountForUser) {
        this.finalAmountForUser = finalAmountForUser;
    }
}
