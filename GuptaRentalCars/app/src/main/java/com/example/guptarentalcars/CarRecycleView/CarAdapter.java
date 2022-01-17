package com.example.guptarentalcars.CarRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guptarentalcars.R;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    List<CarBean> myList = new ArrayList<>();

    public CarAdapter(List<CarBean> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        CarBean c = myList.get(position);
        holder.textView.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgIcon);
            textView = (TextView) itemView.findViewById(R.id.textTitle);
        }
    }
}
