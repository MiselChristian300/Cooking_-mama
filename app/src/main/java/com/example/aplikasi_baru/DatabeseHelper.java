package com.example.aplikasi_baru;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabeseHelper extends SQLiteOpenHelper {

    public static final String datbaseName = "Signup.db";

    public DatabeseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(emai Text primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("drop Table if exists allusers");

    }
    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("allusers",null, contentValues);
        if (result == -1){
           return  false;
        }else {
            return true;
        }

    }
    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email = ?", new String[]{email});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }

    }
    public Boolean checkEmailPassword(String email, String password){

        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email = ? AND password = ?", new String[]{email, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}

