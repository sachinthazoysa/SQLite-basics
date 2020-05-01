package com.example.labsheet5.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHandler(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserMaster.Users.TABLE_NAME + " (" +
                        UserMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UserMaster.Users.COLUMN_NAME_USERNAME + " Text," +
                        UserMaster.Users.COLUMN_NAME_PASSWORD + " Text,";


        db.execSQL(SQL_CREATE_ENTRIES);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
