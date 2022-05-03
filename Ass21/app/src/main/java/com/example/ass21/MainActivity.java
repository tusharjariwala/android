package com.example.ass21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editname,editage,editaddress,editcity,editphone;
Button btnsub;
TextView txtphone,txtcity,txtage,txtname,txtadress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsub=findViewById(R.id.btnsub);
        txtphone=findViewById(R.id.txtphone);
        txtcity=findViewById(R.id.txtcity);
        txtage=findViewById(R.id.txtage);
        txtname=findViewById(R.id.txtname);
        txtadress=findViewById(R.id.txtadress);
        editname=findViewById(R.id.editname);
        editage=findViewById(R.id.editage);
        editaddress=findViewById(R.id.editaddress);
        editcity=findViewById(R.id.editcity);
        editphone=findViewById(R.id.editphone);
       btnsub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(MainActivity.this,secondActivity.class);
               intent.putExtra("name",editname.getText().toString());
               intent.putExtra("age",editage.getText().toString());
               intent.putExtra("address",editaddress.getText().toString());
               intent.putExtra("city",editcity.getText().toString());
               intent.putExtra("phone",editphone.getText().toString());
               startActivity(intent);
           }
       });

    }
}