package com.example.fosterj.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fosterj on 3/21/18.
 */

public class datahelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data.db";
    private static final String TABLE_NAME = "words";
    private static final String COLUMN_SYNONYM = "synonym";
    private static final String COLUMN_ANTONYM = "antonym";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table words (synonym text not null , antonym text not null);";

    public datahelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertData(data d) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLUMN_SYNONYM, d.getSynonym());
        values.put(COLUMN_ANTONYM, d.getAntonym());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchAnt(String synonym) {
        db = this.getReadableDatabase();
        String query = "select synonym, antonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do{
                a = cursor.getString(0);

                if (a.equals(synonym)) {
                    b = cursor.getString(1);
                    break;
                }
            } while(cursor.moveToNext());
        }
        return b;
    }

    public String searchSyn(String antonym) {
        db = this.getReadableDatabase();
        String query = "select antonym, synonym from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do{
                a = cursor.getString(0);

                if (a.equals(antonym)) {
                    b = cursor.getString(1);
                    break;
                }
            } while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
