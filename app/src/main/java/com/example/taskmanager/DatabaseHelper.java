package com.example.taskmanager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.concurrent.Callable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TASK_RECORD";
    private static final String TABLE_NAME = "TASK_DATA";
    private static final String COL_2 = "TASK";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT , TASK TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String task ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , task);

        long var = db.insert(TABLE_NAME , null , values);
        if(var == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean updateData(String id, String task ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2 , task);

        db.update(TABLE_NAME , contentValues , "ID=?" , new  String[]{id});
        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME , "ID=?" , new String[]{id});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME , null);
        return cursor;
    }
}