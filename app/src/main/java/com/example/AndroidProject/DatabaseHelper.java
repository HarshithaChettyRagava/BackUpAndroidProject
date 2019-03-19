package com.example.AndroidProject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "Customer_table";
//    private static final String COL1 = "ID";
    private static final String COL1 = "name";
    private static final String COL2 = "email";
    private static final String COL3 = "address";
    private static final String COL4 = "phoneNo";
    private static final String COL5 = "password";
    private static final String COL6 = "confirmPwd";
    private static final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Customer_table(name, email, address, phoneNo, password, confirmPwd)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }

    public boolean addData(String item1, String item2, String item3, String item4, String item5, String item6){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item1);
        contentValues.put(COL2, item2);
        contentValues.put(COL3, item3);
        contentValues.put(COL4, item4);
        contentValues.put(COL5, item5);
        contentValues.put(COL6, item6);

        //Log.d(TAG, "addData: Adding "+ item1 + " to "+TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor allData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Customer_table", null);
        return cursor;
    }
}
