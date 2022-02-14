package com.example.earnmore.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresOptIn;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.earnmore.R;
import com.example.earnmore.adapter.OfferAdapter;
import com.example.earnmore.model.Offers;
import com.example.earnmore.model.PaytmSuccessTransactionResponse;
import com.example.earnmore.model.PaytmToken;
import com.example.earnmore.model.PaytmTokenResponse;
import com.example.earnmore.retrofit.MyRetrofitClient;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.paytm.pgsdk.TransactionManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfferFragment extends Fragment implements OfferAdapter.demoApiCalling {

    private static final Logger logger = Logger.getLogger("OfferFragment");
    Integer ActivityRequestCode = 2;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.offerRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        List<Offers> offersList = new ArrayList();
        Offers offers1 = new Offers("399 -/ Only", 399, "Sabka katega", 60, 10, 600);
        Offers offers2 = new Offers("699 -/ Only", 699, "Sabka katega", 45, 7, 900);
        Offers offers3 = new Offers("999 -/ Only", 999, "Sabka katega", 30, 5, 1200);
        Offers offers4 = new Offers("1299 -/ Only", 1299, "Sabka katega", 20, 3, 1500);
        Offers offers5 = new Offers("1599 -/ Only", 1599, "Sabka katega", 10, 1, 1800);

        offersList.add(offers1);
        offersList.add(offers2);
        offersList.add(offers3);
        offersList.add(offers4);
        offersList.add(offers5);


        recyclerView.setAdapter(new OfferAdapter(offersList, this));
        return view;
    }


    @Override
    public void nachoBc(String text) {
        Bundle bundle = new Bundle();
        bundle.putString("vasu", text);
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
        MoreInfoOfferFragment moreInfoOfferFragment = new MoreInfoOfferFragment();
        moreInfoOfferFragment.setArguments(bundle);
        FragmentTransaction aboutUsTransaction = getFragmentManager().beginTransaction();
        aboutUsTransaction.replace(R.id.content, moreInfoOfferFragment, "");
        aboutUsTransaction.commit();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ActivityRequestCode && data != null) {
            //Toast.makeText(this, data.getStringExtra("nativeSdkForMerchantMessage") + data.getStringExtra("response"), Toast.LENGTH_SHORT).show();
            System.out.print("Response= " + data.getStringExtra("nativeSdkForMerchantMessage") + data.getStringExtra("response"));
            Log.i("response", data.getStringExtra("nativeSdkForMerchantMessage") + data.getStringExtra("response"));
            MoreInfoOfferFragment moreInfoOfferFragment = new MoreInfoOfferFragment();
            Bundle bundle = new Bundle();
            bundle.putString("vasu", "chal gya paytm");
            moreInfoOfferFragment.setArguments(bundle);
            FragmentTransaction aboutUsTransaction = getFragmentManager().beginTransaction();
            aboutUsTransaction.replace(R.id.content, moreInfoOfferFragment, "");
            aboutUsTransaction.commit();
        }
    }

    @Override
    public void buyOffer(Offers offers) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("Offer- " + offers.getOfferName());
            int totalBill = offers.getOfferAmount() + 1;
            builder.setMessage("You are purchasing " + offers.getOfferName() + "\n MRP " + offers.getOfferAmount() + "\n Tax  " + " 1" +
                    "\n Total " + totalBill);
            builder.setIcon(R.drawable.money);
            builder.setPositiveButton("Pay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    progressDialog = new ProgressDialog(getContext());
                    progressDialog.setMessage("Processing Please wait");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    String mobileNumber = "7017822912";
                    long orderId = Long.parseLong(mobileNumber) + System.currentTimeMillis();
                    PaytmToken paytmToken = new PaytmToken("7017822912", orderId, totalBill);
                    Call<JsonObject> call = MyRetrofitClient.getInstance().getMyApi().getPostData(paytmToken);
                    call.enqueue(new Callback<JsonObject>() {
                        @Override
                        public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                            try {
                                progressDialog.dismiss();
                                Bundle bundle = new Bundle();
                                JsonObject paytmTokenResponse = response.body();
                                JsonObject paytmTokenResponseBody = (JsonObject) paytmTokenResponse.get("body");
                                JsonObject paytmResultInfo = (JsonObject) paytmTokenResponseBody.get("resultInfo");
                                String paytmTokenResultStatus = paytmResultInfo.get("resultStatus").toString().replace("\"", "");
                                String paytmTokenResultCode = paytmResultInfo.get("resultCode").toString().replace("\"", "");
                                if (paytmTokenResultStatus.equals("S") && paytmTokenResultCode.equals("0000")) {
                                    String paytmTxnToken = paytmTokenResponseBody.get("txnToken").toString().replace("\"", "");
                                    String paytmMID = "<YOUR PAYTM MID>";
                                    String host = "https://securegw-stage.paytm.in/";
                                    String callBackUrl = host + "theia/paytmCallback?ORDER_ID=" + orderId;
                                    PaytmOrder paytmOrder = new PaytmOrder(Long.toString(orderId), paytmMID,
                                            paytmTxnToken, Integer.toString(totalBill), callBackUrl);
                                    TransactionManager transactionManager = new TransactionManager(paytmOrder, new PaytmPaymentTransactionCallback() {
                                        @Override
                                        public void onTransactionResponse(@Nullable Bundle bundle) {
                                            String txnStatus = bundle.getString("STATUS");
                                            String txnAmount = bundle.getString("TXNAMOUNT");
                                            String txnDate = bundle.getString("TXNDATE");
                                            String txnID = bundle.getString("TXNID");
                                            if (txnStatus.equals("TXN_SUCCESS")) {
                                                savePaytmSuccessTransaction(bundle);
                                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                                builder.setIcon(R.drawable.money)
                                                        .setMessage("Congrats Payment has been done \n"
                                                                + "Payment " + txnStatus + "\n"
                                                                + "Amount " + txnAmount + "\n"
                                                                + "Date " + txnDate + "\n"
                                                                + "TxnId " + txnID)
                                                        .setTitle("Congratulations")
                                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                Toast.makeText(getContext(), "Thanks For Purchasing", Toast.LENGTH_LONG).show();
                                                            }
                                                        });
                                                builder.create().show();
                                            } else {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                                builder.setIcon(R.drawable.money)
                                                        .setTitle("Sorry")
                                                        .setMessage("Payment fail please try again")
                                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                                OfferFragment offerFragment = new OfferFragment();
                                                                FragmentTransaction offerTransaction = getFragmentManager().beginTransaction();
                                                                offerTransaction.replace(R.id.content, offerFragment, "");
                                                                offerTransaction.commit();
                                                            }
                                                        });
                                            }

                                        }

                                        @Override
                                        public void networkNotAvailable() {

                                        }

                                        @Override
                                        public void onErrorProceed(String s) {

                                        }

                                        @Override
                                        public void clientAuthenticationFailed(String s) {

                                        }

                                        @Override
                                        public void someUIErrorOccurred(String s) {

                                        }

                                        @Override
                                        public void onErrorLoadingWebPage(int i, String s, String s1) {

                                        }

                                        @Override
                                        public void onBackPressedCancelTransaction() {

                                        }

                                        @Override
                                        public void onTransactionCancel(String s, Bundle bundle) {

                                        }
                                    });
                                    transactionManager.setShowPaymentUrl(host + "theia/api/v1/showPaymentPage");
                                    transactionManager.startTransaction(getActivity(), ActivityRequestCode);
                                    bundle.putString("vasu", paytmTxnToken);
                                } else {
                                    progressDialog.dismiss();
                                    bundle.putString("vasu", response.body().toString());
                                }

                            } catch (Exception e) {
                                progressDialog.dismiss();
                                e.printStackTrace();
                                Toast.makeText(getContext(), "Something went wrong please try again after some time", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<JsonObject> call, Throwable t) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Something went wrong please try again after some time", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getContext(), "You have cancelled the purchase", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePaytmSuccessTransaction(Bundle bundle) {
        try {
            PaytmSuccessTransactionResponse response = new PaytmSuccessTransactionResponse();
            response.setBankName(bundle.getString("BANKNAME"));
            response.setResponseCode(bundle.getString("RESPCODE"));
            response.setResponseMessage(bundle.getString("RESPMSG"));
            response.setCurrency(bundle.getString("CURRENCY"));
            response.setStatus(bundle.getString("STATUS"));
            response.setCheckSumHash(bundle.getString("CHECKSUMHASH"));
            response.setOrderId(bundle.getString("ORDERID"));
            response.setTxnAmount(bundle.getString("TXNAMOUNT"));
            response.setTxnDate(bundle.getString("TXNDATE"));
            response.setTxnId(bundle.getString("TXNID"));
            response.setPaymentMode(bundle.getString("PAYMENTMODE"));
            response.setBankTxnId(bundle.getString("BANKTXNID"));
            response.setGatewayName(bundle.getString("GATEWAYNAME"));
            Call<JsonObject> call = MyRetrofitClient.getInstance().getMyApi().saveTransactionSuccessResponse(response);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    Toast.makeText(getContext(), "Paytm Trans Save Success", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Toast.makeText(getContext(), "Paytm Trans Save Fail", Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}