package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.notepad.adapter.NoteAdapter;
import com.example.notepad.model.Note;

import java.util.ArrayList;
import java.util.List;

public class Notes extends AppCompatActivity implements SelectListener{

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

        notes=new DbHandler(this).getNote();

        NoteAdapter noteAdapter=new NoteAdapter(this, notes,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,4,GridLayoutManager.VERTICAL,false);
        noteList.setLayoutManager(gridLayoutManager);
        noteList.setAdapter(noteAdapter);
    }

    @Override
    public void onItemClicked(Note note) {
        Intent intent=new Intent(getApplicationContext(),Display.class);
        intent.putExtra("NOTE_ID",note.getId());
        startActivity(intent);
//        Toast.makeText(this,note.getTitle(),Toast.LENGTH_SHORT).show();
    }
}