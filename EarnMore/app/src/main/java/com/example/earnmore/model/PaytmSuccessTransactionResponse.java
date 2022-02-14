package com.example.earnmore.model;

public class PaytmSuccessTransactionResponse {
    private String status;
    private String checkSumHash;
    private String bankName; //
    private String orderId;
    private String txnAmount;
    private String txnDate;
    private String txnId;
    private String responseCode; //
    private String paymentMode;
    private String bankTxnId;
    private String currency; //
    private String gatewayName;
    private String responseMessage; //

    public PaytmSuccessTransactionResponse() {
    }

    public PaytmSuccessTransactionResponse(String status, String checkSumHash, String bankName, String orderId, String txnAmount, String txnDate, String txnId, String responseCode, String paymentMode, String bankTxnId, String currency, String gatewayName, String responseMessage) {
        this.status = status;
        this.checkSumHash = checkSumHash;
        this.bankName = bankName;
        this.orderId = orderId;
        this.txnAmount = txnAmount;
        this.txnDate = txnDate;
        this.txnId = txnId;
        this.responseCode = responseCode;
        this.paymentMode = paymentMode;
        this.bankTxnId = bankTxnId;
        this.currency = currency;
        this.gatewayName = gatewayName;
        this.responseMessage = responseMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckSumHash() {
        return checkSumHash;
    }

    public void setCheckSumHash(String checkSumHash) {
        this.checkSumHash = checkSumHash;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(String txnAmount) {
        this.txnAmount = txnAmount;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankTxnId() {
        return bankTxnId;
    }

    public void setBankTxnId(String bankTxnId) {
        this.bankTxnId = bankTxnId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
