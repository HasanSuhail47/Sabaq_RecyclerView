package com.example.sabaq_recycler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "SABAQ.db";
    private static final String TABLE_NAME = "STUDENT_DATA";

    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_SABAQ = "SABAQ";
    private static final String COLUMN_SABQI = "SABQi";
    private static final String COLUMN_MANZIL = "MANZIL";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SABAQ + " TEXT,"
                + COLUMN_SABQI + " TEXT,"
                + COLUMN_MANZIL + " TEXT "
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertdata(Student st) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, st.getName());
        values.put(COLUMN_SABAQ, st.getSabaq());
        values.put(COLUMN_SABQI, st.getSabqi());
        values.put(COLUMN_MANZIL, st.getManzil());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void ifexist(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_NAME+" = "+name;
        Cursor c=db.rawQuery(sql,null);

        if(c.moveToFirst())
        {

        }
    }

    public List<Student> getallnamaz() {
        List<Student> st_list = new ArrayList<Student>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                    st_list.add(new Student(
                            cursor.getString(cursor.getColumnIndex(COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_SABAQ)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_SABQI)),
                            cursor.getString(cursor.getColumnIndex(COLUMN_MANZIL))
                    ));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return st_list;
    }
}