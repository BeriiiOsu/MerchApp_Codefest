package com.beriii.merchapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TestDB.db";
    private static final int DATABASE_VER = 1;

    private static final String TABLE_NAME = "TBL_USERS";
    private static final String COLUMN_ID = "USER_ID";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_EMAIL = "EMAIL_ADDRESS";
    private static final String COLUMN_PASSWORD = "PASSWORD";


    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " VARCHAR(50), " + COLUMN_EMAIL + " VARCHAR(50) UNIQUE, " +
                    COLUMN_PASSWORD + " VARCHAR(50));";

    public Database (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertUserSiqnUp(String username, String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public Cursor getData(String user){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " where USERNAME=?", new String[]{user});
    }

}
