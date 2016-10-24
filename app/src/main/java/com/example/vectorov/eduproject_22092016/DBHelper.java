package com.example.vectorov.eduproject_22092016;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vectorov on 08.10.2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "DB";
    private static int DB_VERSION = 8;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        db.execSQL("create table IF NOT EXISTS stores ("
                +StoreContract.id+" INTEGER PRIMARY KEY,"
                +StoreContract.name+" text,"
                +StoreContract.address+" text,"
                +StoreContract.phone+" text"
                +");");
        db.execSQL("create table IF NOT EXISTS tools ("
                +ToolsContract.id+" INTEGER PRIMARY KEY,"
                +ToolsContract.storeId+" integer,"
                +ToolsContract.brand+" text,"
                +ToolsContract.model+" text,"
                +ToolsContract.imageUrl+" text,"
                +ToolsContract.type+" text,"
                +ToolsContract.price+" real,"
                +ToolsContract.quantity+" integer"
                +");");
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {db.beginTransaction();
        db.execSQL("drop table IF EXISTS stores;");
        db.execSQL("drop table IF EXISTS tools;");
        onCreate(db);
        db.setTransactionSuccessful();
        db.endTransaction();
    }
}
