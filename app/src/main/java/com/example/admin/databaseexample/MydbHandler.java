package com.example.admin.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MydbHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "Studentdb.db";
    private static final String TABLE_NAME = "Student";
    private static final String COLUMN_ID = "St_id";
    private static final String COLUMN_NAME = "Student_name";

    public MydbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    void addName(Student student){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ID, student.getId());
        sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
    }

    public Student findHandler(String name) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { COLUMN_ID,
                        COLUMN_NAME }, COLUMN_NAME + "=?",
                new String[] { String.valueOf(name) }, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
            Student student = new Student(Integer.parseInt(cursor.getString(0)),cursor.getString(1));
            return student;
        }
        return null;
    }
}
