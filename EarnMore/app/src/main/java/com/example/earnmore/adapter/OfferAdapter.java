package com.example.earnmore.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earnmore.R;
import com.example.earnmore.model.Offers;

import java.util.ArrayList;
import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {

    List<Offers> offersList = new ArrayList();
    private demoApiCalling apiCalling;
    Fragment fr;

    public OfferAdapter(List<Offers> offersList, demoApiCalling apiCalling) {
        this.apiCalling = apiCalling;
        this.offersList = offersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.offers_scroll_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Offers offers = offersList.get(position);

        holder.tvOfferName.setText("Offer Name - " + offers.getOfferName());
        holder.tvAmountUserPay.setText("You have to pay - " + offers.getOfferAmount());
        holder.tvAmountUserReceive.setText("AmountYou recieve - " + offers.getFinalAmountForUser());
        holder.tvOfferValidityDay.setText("Offer Validity - " + offers.getOfferValidityDay());
        holder.tvUserToAdd.setText("User you have to add - " + offers.getOfferMinUserToAdd());
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }


    private void showMoreInfo(View view) {
        TextView text = (TextView) view.findViewById(R.id.offer_name);
        System.out.print("Data= " + text);
    }

    public interface demoApiCalling {
        public void nachoBc(String text);

        public void buyOffer(Offers offers);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOfferName;
        TextView tvAmountUserPay;
        TextView tvAmountUserReceive;
        TextView tvUserToAdd;
        TextView tvOfferValidityDay;
        Button btnMoreInfo;
        Button btnBuyNow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOfferName = (TextView) itemView.findViewById(R.id.offer_name);
            tvAmountUserPay = (TextView) itemView.findViewById(R.id.offer_amount);
            tvAmountUserReceive = (TextView) itemView.findViewById(R.id.offer_final_return_amount);
            tvUserToAdd = (TextView) itemView.findViewById(R.id.offer_user_to_add);
            tvOfferValidityDay = (TextView) itemView.findViewById(R.id.offer_day_validity);

            btnMoreInfo = (Button) itemView.findViewById(R.id.offer_more_info);
            btnBuyNow = (Button) itemView.findViewById(R.id.offer_buy_now);


            btnMoreInfo.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String text = tvOfferValidityDay.getText().toString();
                    apiCalling.nachoBc(text);
                }
            });

            btnBuyNow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Offers offers = new Offers();
                    String offerName  = tvOfferName.getText().toString().replace("Offer Name - ","");
                    String offerAmount = tvAmountUserPay.getText().toString().replace("You have to pay - ","");
                    offers.setOfferName(offerName);
                    offers.setOfferAmount(Integer.parseInt(offerAmount));
                    apiCalling.buyOffer(offers);
                }

            });
        }

    }
}
