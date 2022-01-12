package com.example.recycleviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycleviewproject.adapters.RecipeAdapters;
import com.example.recycleviewproject.model.RecipeModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);

        List<RecipeModel> list = new ArrayList<>();

        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 1"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 2"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 3"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 4"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 5"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 6"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 7"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 8"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 9"));
        list.add(new RecipeModel(R.drawable.ic_launcher_foreground, " Car Lover 10"));

        RecipeAdapters adapters = new RecipeAdapters(list, this);
        recyclerView.setAdapter(adapters);

//        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayout);

        //Horizontal Scroll false means from left To Right Scroll and true means right to left scroll
//        LinearLayoutManager linearLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(linearLayout);

        GridLayoutManager gridManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridManager);
    }
}