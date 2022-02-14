package com.example.earnmore.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.earnmore.MainActivity;
import com.example.earnmore.R;
import com.example.earnmore.fragments.EarningFragment;
import com.example.earnmore.fragments.HomeFragment;
import com.example.earnmore.fragments.OfferFragment;
import com.example.earnmore.fragments.RefrenceCode;
import com.example.earnmore.fragments.UsersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EarnMoreActivity extends AppCompatActivity {

    BottomNavigationView nav;
    Button copyRefCodeBtn;
    TextView refCodeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_more);

        copyRefCodeBtn = (Button) findViewById(R.id.copyRefCodeBTN);

        nav = (BottomNavigationView) findViewById(R.id.navigation);
        nav.setOnNavigationItemSelectedListener(listener);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, homeFragment, "");
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_nav_menu, menu);
        return true;
    }

    public void copyRefCode(View view) {
        refCodeTv = (TextView) findViewById(R.id.refCodeTV);
        ClipboardManager cm = (ClipboardManager) this.getSystemService(this.CLIPBOARD_SERVICE);
        cm.setText(refCodeTv.getText());
        Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
    }

    public void shareRefCode(View view) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        refCodeTv = (TextView) findViewById(R.id.refCodeTV);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Reference Code");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, refCodeTv.getText());
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.referenceCode:
                RefrenceCode referenceCodeFragment = new RefrenceCode();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, referenceCodeFragment, "");
                transaction.commit();
                break;
            case R.id.paytmTransaction:
            case R.id.logout:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottomNavHome:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction homeTransaction = getSupportFragmentManager().beginTransaction();
                    homeTransaction.replace(R.id.content, homeFragment, "");
                    homeTransaction.commit();
                    break;
                case R.id.bottomNavOffer:
                    OfferFragment offerFragment = new OfferFragment();
                    FragmentTransaction offerTransaction = getSupportFragmentManager().beginTransaction();
                    offerTransaction.replace(R.id.content, offerFragment, "");
                    offerTransaction.commit();
                    break;
                case R.id.bottomNavEarning:
                    EarningFragment earningFragment = new EarningFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content, earningFragment, "");
                    transaction.commit();
                    break;
                case R.id.bottomNavUsers:
                    UsersFragment aboutUsFragment = new UsersFragment();
                    FragmentTransaction aboutUsTransaction = getSupportFragmentManager().beginTransaction();
                    aboutUsTransaction.replace(R.id.content, aboutUsFragment, "");
                    aboutUsTransaction.commit();
                    break;
            }
            return false;
        }
    };
}