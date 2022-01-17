package com.example.guptarentalcars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.guptarentalcars.fragments.BookingFragment;
import com.example.guptarentalcars.fragments.CarsFragment;
import com.example.guptarentalcars.fragments.HomeFragment;
import com.example.guptarentalcars.fragments.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarsMainActivity extends AppCompatActivity {

    BottomNavigationView nav;
    ViewFlipper flipperHomeImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_main);

        nav = (BottomNavigationView) findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(listener);




        HomeFragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragment, "");
        transaction.commit();
    }




    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.cars:
                    CarsFragment fragment = new CarsFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragment, "");
                    fragmentTransaction.commit();
                    return true;

                case R.id.home:
                    HomeFragment fragment1 = new HomeFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content, fragment1);
                    fragmentTransaction1.commit();
                    return true;

                case R.id.booking:
                    BookingFragment bookingFraObj = new BookingFragment();
                    FragmentTransaction bookingFragTransaction = getSupportFragmentManager().beginTransaction();
                    bookingFragTransaction.replace(R.id.content, bookingFraObj);
                    bookingFragTransaction.commit();
                    return true;

                case R.id.more:
                    MoreFragment moreFraObj = new MoreFragment();
                    FragmentTransaction moreFragTransaction = getSupportFragmentManager().beginTransaction();
                    moreFragTransaction.replace(R.id.content, moreFraObj);
                    moreFragTransaction.commit();
                    return true;
            }
            return false;
        }
    };
}