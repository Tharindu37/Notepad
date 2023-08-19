package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
    private EditText search;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        saveButton=findViewById(R.id.btnAdd);
        noteList=findViewById(R.id.lstNotes);
        search=findViewById(R.id.txtSearch);
        dbHandler=new DbHandler(this);

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

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String query = search.getText().toString().trim();
                List<Note> searchResults = dbHandler.searchNotesByTitle(query);
                NoteAdapter searchAdapter=new NoteAdapter(Notes.this, searchResults,Notes.this);
                noteList.setAdapter(searchAdapter);
            }
        });
    }

    @Override
    public void onItemClicked(Note note) {
        Intent intent=new Intent(getApplicationContext(),Display.class);
        intent.putExtra("NOTE_ID",note.getId());
        startActivity(intent);
//        Toast.makeText(this,note.getTitle(),Toast.LENGTH_SHORT).show();
    }
}