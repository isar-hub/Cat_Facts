package com.example.catfacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBname ="login.db";

    public DBHelper(Context context) {
        super(context,DBname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(username TEXT primary key, password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop table if exists users");
    }

    public boolean insertData(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = myDB.insert("users",null,contentValues);
        if (result == 1){
            return false;
        }
        else {
            return true;
        }

    }
    public boolean checkUserName(String username){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from users where username = ?",new String[]{username});
        if (cursor.getCount()> 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where username = ? and password =?", new String[] {username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
}

