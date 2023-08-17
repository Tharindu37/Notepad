package com.example.notepad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.notepad.model.Note;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final String DB_NAME="notes";
    private static final int VERSION=1;

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE note(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, date TEXT, note TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS note";
        db.execSQL(sql);
        onCreate(db);
    }

    public void saveNote(Note note){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("title",note.getTitle());
        contentValues.put("date",note.getDate());
        contentValues.put("note",note.getNote());

        //save to table
        sqLiteDatabase.insert("note",null,contentValues);
        //close database
        sqLiteDatabase.close();
    }

    public List<Note> getNote(){
        List<Note> notes=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        String sql="SELECT * FROM note";

        Cursor cursor=database.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                Note note=new Note();
                note.setId(cursor.getInt(0));
                note.setTitle(cursor.getString(1));
                note.setDate(cursor.getString(2));
                note.setNote(cursor.getString(3));

                notes.add(note);
            }while (cursor.moveToNext());
        }
        return notes;
    }
}
