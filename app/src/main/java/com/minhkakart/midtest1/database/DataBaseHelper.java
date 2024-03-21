package com.minhkakart.midtest1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.minhkakart.midtest1.models.UserModel;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mid_test1.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_USER = "user";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_USER + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, name TEXT, created_at TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_USER;
        db.execSQL(sql);
        onCreate(db);
    }

    public long addUser(UserModel user){
        SQLiteDatabase db = this.getWritableDatabase();

//        String sql = "INSERT INTO " + TABLE_USER + " (username, password, name, created_at) VALUES ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getName() + "', '" + user.getCreated_at() + "')";
//        db.execSQL(sql);

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user.getUsername());
        contentValues.put("password", user.getPassword());
        contentValues.put("name", user.getName());
        contentValues.put("created_at", user.getCreated_at());

        return db.insert(TABLE_USER, null, contentValues);

    }

    public UserModel findUser(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE username = '" + username + "' AND password = '" + password + "'";
        if (db != null){
            try (Cursor cursor = db.rawQuery(sql, null)) {
                if (cursor.moveToFirst()){
                    int id = cursor.getInt(0);
                    String name = cursor.getString(3);
                    return new UserModel(id, username, password, name);
                }
            }
        }
        return null;
    }

}
