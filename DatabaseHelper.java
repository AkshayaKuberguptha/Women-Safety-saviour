package com.vinayak09.wsafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "login.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME="MMB";







    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user(ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT, ph_number INT  )");
        db.execSQL("CREATE TABLE MMB(ID INTEGER PRIMARY KEY AUTOINCREMENT, name_donate TEXT, email_donate TEXT, age INT, ph_number_donate INT, address TEXT, healthissue TEXT, medication_adherence TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS MMB");
        onCreate(db);
    }


    public boolean Insert(String username, String password,String email,String ph_number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email",email);
        contentValues.put("ph_number",ph_number);
        long result = sqLiteDatabase.insert("user", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckUsername(String username, String password, String email, String ph_number){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=? AND email=? AND ph_number=?", new String[]{username,password,email,ph_number});
        if(cursor.getCount() > 0){
            return false;
        }else{
            return true;
        }
    }

    public Boolean CheckLogin(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM user WHERE username=? AND password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
