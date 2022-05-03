package com.example.ass25;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "employee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
       DB.execSQL("create Table employeedetails(name TEXT primary key,age TEXT,address TEXT,city TEXT,phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
      DB.execSQL("drop Table if exists employeedetails");
    }
    public Boolean insertemployee(String name,String age,String address,String city,String phone) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("address", address);
        contentValues.put("city", city);
        contentValues.put("phone", phone);
        long result = DB.insert("employeedetails", null, contentValues);
        if (result == 1) {
            return false;
        } else {
            return true;
        }
    }
        public Boolean updateemployee(String name,String age,String address,String city,String phone)
        {
            SQLiteDatabase DB=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();

            contentValues.put("age",age);
            contentValues.put("address",address);
            contentValues.put("city",city);
            contentValues.put("phone",phone);
            Cursor cursor=DB.rawQuery("select * from employeedetails where name=? ",new String[] {name});
             if(cursor.getCount()>0) {
                 long result = DB.update("employeedetails", contentValues, "name=?", new String[]{name});
                 if (result == -1) {
                     return false;
                 } else {
                     return true;
                 }
             }else
             {
                 return false;
             }
    }
    public Boolean deleteemployee(String name)
    {
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("select * from employeedetails where name=? ",new String[] {name});
        if(cursor.getCount()>0) {
            long result = DB.delete("employeedetails", "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else
        {
            return false;
        }
    }
    public Cursor getData()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from employeedetails ",null);
        return cursor;
    }
}
