package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.notepad.adapter.NoteAdapter;
import com.example.notepad.model.Note;

import java.util.ArrayList;
import java.util.List;

public class Notes extends AppCompatActivity {

    private ImageButton saveButton;
    private List<Note> notes;

    private RecyclerView noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        saveButton=findViewById(R.id.btnAdd);
        noteList=findViewById(R.id.lstNotes);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Edit.class);
                startActivity(intent);
            }
        });

//        notes=new ArrayList<>();
//        notes.add(new Note(1,"first","2000/3/4","dljlsjalejljl jljslfj"));
//        notes.add(new Note(2,"second","2000/3/4","dljlsjalejljl jljslfj"));
//        notes.add(new Note(3,"forth","2000/3/4","dljlsjaleeeejljl jljslfj"));
//        notes.add(new Note(4,"size","2000/3/4","dljlsjaleeeeejljl jljslfj"));
//        notes.add(new Note(5,"vgsfj","2000/3/4","dljlsjeealejljl jljslfj"));

        notes=new DbHandler(this).getNote();

        NoteAdapter noteAdapter=new NoteAdapter(this, notes);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false);
        noteList.setLayoutManager(gridLayoutManager);
        noteList.setAdapter(noteAdapter);
    }
}