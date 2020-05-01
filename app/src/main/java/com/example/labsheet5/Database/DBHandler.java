package com.example.labsheet5.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
                        UserMaster.Users.COLUMN_NAME_PASSWORD + " Text)";
        db.execSQL(SQL_CREATE_ENTRIES);
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addInfo(String userName,String password){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserMaster.Users.COLUMN_NAME_USERNAME, userName);
        values.put(UserMaster.Users.COLUMN_NAME_PASSWORD, password);

        Long newRowId= db.insert(UserMaster.Users.TABLE_NAME, null, values);
    }


    public List readAllInfo(){
        SQLiteDatabase db= getReadableDatabase();

        String[] projection = {
                UserMaster.Users._ID,
                UserMaster.Users.COLUMN_NAME_USERNAME,
                UserMaster.Users.COLUMN_NAME_PASSWORD
        };
        String sortOrder = UserMaster.Users.COLUMN_NAME_USERNAME + " DESC";
        Cursor cursor =db.query(
                UserMaster.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List userNames= new ArrayList<>();
        List passwords= new ArrayList<>();

        while (cursor.moveToNext()){
            String username= cursor.getString(cursor.getColumnIndexOrThrow((UserMaster.Users.COLUMN_NAME_USERNAME)));
            String password= cursor.getString(cursor.getColumnIndexOrThrow((UserMaster.Users.COLUMN_NAME_PASSWORD)));
            userNames.add(username);
            passwords.add(password);
        }
        cursor.close();
        return userNames;

    }
}
