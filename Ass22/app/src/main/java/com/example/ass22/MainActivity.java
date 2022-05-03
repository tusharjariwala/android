package com.example.ass22;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   Button btnAdd;
   EditText et_name;
   ListView listview;
  ArrayList<String> list;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        btnAdd=findViewById(R.id.btnAdd);
        et_name=findViewById(R.id.et_name);

        list=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,list);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String names=et_name.getText().toString();
                 list.add(names);
                 listview.setAdapter(arrayAdapter);
                 arrayAdapter.notifyDataSetChanged();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int listItem, long l) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Do you want to remove"+list.get(listItem)+
                        "from list ")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                list.remove(listItem);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
                return false;
            }
        });

    }
}