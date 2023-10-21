package com.vinayak09.wsafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Donor.db";
    public static final String TABLE_NAME="Donor_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="EMAIL_ID";
    public static final String COL_4="AGE";
    public static final String COL_5="PH_NUMBER";
    public static final String COL_6="ADDRESS";
    public static final String COL_7="HEALTH_ISSUES";
    public static final String COL_8="MEDICATION_ADHERENCE";


    public DatabaseManager(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL_ID TEXT, AGE TEXT, PH_NUMBER TEXT, ADDRESS TEXT, HEALTH_ISSUES TEXT, MEDICATION_ADHERENCE TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME  );
        onCreate(db);
    }
    public boolean insertdata(String name, String email, String age, String ph_number, String address, String health_issue, String medication_adherence) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, age);
        contentValues.put(COL_5, ph_number);
        contentValues.put(COL_6, address);
        contentValues.put(COL_7, health_issue);
        contentValues.put(COL_8, medication_adherence);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur=db.rawQuery("select* from "+TABLE_NAME,null);
        return cur;
    }

}
