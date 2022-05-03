package com.example.ass23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView  listView1=findViewById(R.id.listview1);
        List<String> list=new ArrayList<>();
        list.add("Skype");
        list.add("Snapchat");
        list.add("LinkedIn");
        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView1.setAdapter(arrayAdapter);
           listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                   if(position==0)
                   {
                       startActivity(new Intent(MainActivity.this,SkypeActivity.class));
                   }else if (position==1)
                   {
                       startActivity(new Intent(MainActivity.this,SnapchatActivity.class));
                   }else if(position==2)
                   {
                       startActivity(new Intent(MainActivity.this,LinkedInActivity.class));
                   }else
                   {

                   }
               }
           });
    }
}