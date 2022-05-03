package com.example.ass21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
 TextView displayname,displayage,displayaddress,displaycity,displayphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        displayname=findViewById(R.id.displayname);
        displayage=findViewById(R.id.displayage);
        displayaddress=findViewById(R.id.displayaddress);
        displaycity=findViewById(R.id.displaycity);
        displayphone=findViewById(R.id.displayphone);
        Intent intent=getIntent();

         String name=intent.getStringExtra("name");
        displayname.setText(name);
        String age=intent.getStringExtra("age");
        displayage.setText(age);
        String address=intent.getStringExtra("address");
        displayaddress.setText(address);
        String city=intent.getStringExtra("city");
        displaycity.setText(city);
        String phone=intent.getStringExtra("phone");
        displayphone.setText(phone);


    }
}