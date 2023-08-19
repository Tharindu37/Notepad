package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notepad.model.Note;

public class Edit extends AppCompatActivity {

    private EditText title;
    private EditText data;
    private EditText note;

    private Button save;
    private Button close;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        title=findViewById(R.id.edtTitle);
        data=findViewById(R.id.edtDate);
        note=findViewById(R.id.edtNote);
        save=findViewById(R.id.btnSave);
        close=findViewById(R.id.btnClose);
        dbHandler=new DbHandler(this);

        Intent intent=getIntent();
        if (intent.hasExtra("NOTE_ID")){
            int id=intent.getIntExtra("NOTE_ID",-1);
            Note note1=dbHandler.getSingleNote(id);

            title.setText(note1.getTitle());
            data.setText(note1.getDate());
            note.setText(note1.getNote());
            save.setText("Update");
        }


        if (save.getText().toString().equalsIgnoreCase("Save")){
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String titleValue=title.getText().toString();
                    String dateValue=data.getText().toString();
                    String noteValue=note.getText().toString();
                    Note noteObj=new Note(titleValue,dateValue,noteValue);

                    dbHandler.saveNote(noteObj);
                    Intent intent=new Intent(getApplicationContext(), Notes.class);
                    startActivity(intent);
                }
            });
        }else if (save.getText().toString().equalsIgnoreCase("Update")){
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id=intent.getIntExtra("NOTE_ID",-1);
                    String titleValue=title.getText().toString();
                    String dateValue=data.getText().toString();
                    String noteValue=note.getText().toString();
                    Note noteObj=new Note(id,titleValue,dateValue,noteValue);

                    int status=dbHandler.updateNote(noteObj);
                    Intent intent=new Intent(getApplicationContext(), Notes.class);
                    startActivity(intent);
                }
            });
        }

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Notes.class);
                startActivity(intent);
            }
        });


    }
}