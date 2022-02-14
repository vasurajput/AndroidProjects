package com.example.earnmore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.earnmore.activity.EarnMoreActivity;
import com.example.earnmore.activity.Register;

public class MainActivity extends AppCompatActivity {

    private static final String EMPTY_STRING = "";
    private EditText mobileNumber;
    private EditText password;
    private TextView warningMessageTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNumber = (EditText) findViewById(R.id.loginMobileNumber);
        password = (EditText) findViewById(R.id.loginPassword);
        warningMessageTV = (TextView) findViewById(R.id.loginInvalidUserMsgTV);

    }

    public void registerNewUser(View view) {
        Intent registerIntent = new Intent(this, Register.class);
        startActivity(registerIntent);
    }

    public void loginUser(View view) {
        if (mobileNumber.getText().toString().length() < 10 || mobileNumber.getText().toString().length() > 10) {
            warningMessageTV.setText("Enter Valid Mobile Number");
            return;
        }

        if (mobileNumber.getText().toString().equals("7017822912") && password.getText().toString().equals("123")) {
            warningMessageTV.setText(EMPTY_STRING);
            Intent intent = new Intent(this, EarnMoreActivity.class);
            startActivity(intent);
        } else {
            warningMessageTV.setText("Invalid Credentials Try again !!");
        }
    }
}