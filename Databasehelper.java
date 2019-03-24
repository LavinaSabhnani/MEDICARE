package com.example.tanma.medicare2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class Databasehelper extends SQLiteOpenHelper {
    public static final String DBNAME = "sym.db";
    public static final String TBNAME = "sym";
    public static final String col1 = "id";
    public static final String col2 = "diagnosis";
    public static final String col3 = "symptom";


    public Databasehelper(Context context) {
        super(context, DBNAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TBNAME + " (diagnosis TEXT,symptom TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert() {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(col2, "asthma");
        cv.put(col3, "cough");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "asthma");
        cv.put(col3, "chill");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "asthma");
        cv.put(col3, "fatigue");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "asthma");
        cv.put(col3, "shortness of breath");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "asthma");
        cv.put(col3, "backpain");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "dehydration");
        cv.put(col3, "fever");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "dehydration");
        cv.put(col3, "vomiting");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "dehydration");
        cv.put(col3, "nausea");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "dehydration");
        cv.put(col3, "blackout");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "dehydration");
        cv.put(col3, "fatigue");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "influenza");
        cv.put(col3, "fever");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "influenza");
        cv.put(col3, "sore throat");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "influenza");
        cv.put(col3, "chill");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "influenza");
        cv.put(col3, "headache");
        db.insert(TBNAME, null, cv);

        cv.put(col2, "influenza");
        cv.put(col3, "sneeze");
        long result = db.insert(TBNAME, null, cv);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getall() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from sym", null);
        return res;
    }
}
