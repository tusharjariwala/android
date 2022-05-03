package com.example.ass24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ITActivity extends AppCompatActivity {
Button btnit,btnict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itactivity);
      btnit=findViewById(R.id.btnit);
        btnict=findViewById(R.id.btnict);
       btnit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(ITActivity.this,ITcourseActivity.class);
               startActivity(intent);
           }
       });
        btnict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ITActivity.this,ICTcourseActivity.class);
                startActivity(intent);
            }
        });
    }
}