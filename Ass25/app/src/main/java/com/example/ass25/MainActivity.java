package com.example.ass25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText editname,editage,editaddress,editcity,editphone;
 Button btnadd,btndisplay,btnupdate,btndelete;
 DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editname=findViewById(R.id.editname);
        editage=findViewById(R.id.editage);
        editaddress=findViewById(R.id.editaddress);
        editcity=findViewById(R.id.editcity);
        editphone=findViewById(R.id.editphone);
        btnadd=findViewById(R.id.btnadd);
        btndisplay=findViewById(R.id.btndisplay);
        btnupdate=findViewById(R.id.btnupdate);
        btndelete=findViewById(R.id.btndelete);


      DB=new DBHelper(this);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String nametxt= editname.getText().toString();
                String agetxt= editage.getText().toString();
                String addresstxt= editaddress.getText().toString();
                String citytxt= editcity.getText().toString();
                String phonetxt= editphone.getText().toString();

                Boolean checkingData=DB.insertemployee(nametxt,agetxt,addresstxt,citytxt,phonetxt);
               if(checkingData==true)
                   Toast.makeText(MainActivity.this,"Insert",Toast.LENGTH_LONG).show();
               else
                   Toast.makeText(MainActivity.this,"Not Insert",Toast.LENGTH_LONG).show();

            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt= editname.getText().toString();
                String agetxt= editage.getText().toString();
                String addresstxt= editaddress.getText().toString();
                String citytxt= editcity.getText().toString();
                String phonetxt= editphone.getText().toString();

                Boolean checkupdateData=DB.updateemployee(nametxt,agetxt,addresstxt,citytxt,phonetxt);
                if(checkupdateData==true)
                    Toast.makeText(MainActivity.this,"Update",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Not Update",Toast.LENGTH_LONG).show();

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt= editname.getText().toString();

                Boolean checkdeleteData=DB.deleteemployee(nametxt);
                if(checkdeleteData==true)
                    Toast.makeText(MainActivity.this,"Delete",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Not Delete",Toast.LENGTH_LONG).show();

            }
        });
        btndisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.getData();
                if(res.getCount()==0)
                {
                    Toast.makeText(MainActivity.this,"NO Entry",Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Name:"+res.getString(0)+"\n\n");
                    buffer.append("AGE:"+res.getString(1)+"\n\n");
                    buffer.append("Address:"+res.getString(2)+"\n\n");
                    buffer.append("City:"+res.getString(3)+"\n\n");
                    buffer.append("Phone:"+res.getString(4)+"\n\n");

                }
               AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Employee");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }
}