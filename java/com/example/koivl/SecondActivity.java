package com.example.koivl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView result;
    Button Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("UserName")){
            result = (TextView)findViewById(R.id.Result);
            String text = getIntent().getExtras().getString("UserName");
            result.setText("\t"+text+"\n You have Successfully logged in to Koivl ");
         }
        Logout=(Button)findViewById(R.id.logout);
    }

}