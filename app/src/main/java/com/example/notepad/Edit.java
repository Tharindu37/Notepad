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
    }
}