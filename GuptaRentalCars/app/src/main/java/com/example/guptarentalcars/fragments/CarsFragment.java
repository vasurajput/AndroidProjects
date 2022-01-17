package com.example.guptarentalcars.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guptarentalcars.CarRecycleView.CarAdapter;
import com.example.guptarentalcars.CarRecycleView.CarBean;
import com.example.guptarentalcars.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarsFragment newInstance(String param1, String param2) {
        CarsFragment fragment = new CarsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cars, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.programmingList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        List<CarBean> bean = new ArrayList<>();
        CarBean brezza = new CarBean("Brezza");
        CarBean swiftDezire = new CarBean("Gadi chalayega tu BSDK");
        CarBean balleno = new CarBean("Balleno");
        CarBean xuv300 = new CarBean("XUV 300");
        CarBean nano = new CarBean("Tata Nano");
        CarBean accord = new CarBean("Honda Accord");
        CarBean verna = new CarBean("Hundai Verna");
        CarBean city = new CarBean("Honda City");
        CarBean santro = new CarBean("Hundai Santro");
        CarBean eon = new CarBean("Hundai Eon");
        CarBean xuv500 = new CarBean("XUV 500");
        CarBean xuv700 = new CarBean("XUV 700");
        CarBean ecoSport = new CarBean("Ford EcoSport");
        CarBean demo = new CarBean("Demo Car");
        CarBean bhago = new CarBean("Gand Mrao Bc");

        bean.add(brezza);
        bean.add(swiftDezire);
        bean.add(balleno);
        bean.add(xuv300);
        bean.add(nano);
        bean.add(accord);
        bean.add(verna);
        bean.add(city);
        bean.add(santro);
        bean.add(eon);
        bean.add(xuv500);
        bean.add(xuv700);
        bean.add(ecoSport);
        bean.add(demo);
        bean.add(bhago);

        recyclerView.setAdapter(new CarAdapter(bean));
        return view;
    }
}