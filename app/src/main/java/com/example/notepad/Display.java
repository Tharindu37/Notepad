package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.notepad.model.Note;

public class Display extends AppCompatActivity {

    private TextView title;
    private TextView date;
    private TextView description;
    private ImageButton delete;
    private ImageButton edit;
    private Button close;

    DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dbHandler=new DbHandler(this);

        title=findViewById(R.id.txtDisplayTitle);
        date=findViewById(R.id.txtDisplayDate);
        description=findViewById(R.id.txtDisplayNote);
        delete=findViewById(R.id.btnDeleteNote);
        edit=findViewById(R.id.btnEdintNote);

        Intent intent = getIntent();
        if (intent.hasExtra("NOTE_ID")){
            int id=intent.getIntExtra("NOTE_ID",-1);

            Note note=dbHandler.getSingleNote(id);
            title.setText(note.getTitle());
            date.setText(note.getDate());
            description.setText(note.getNote());
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=intent.getIntExtra("NOTE_ID",-1);
                dbHandler.deleteNote(id);
                Intent intent1=new Intent(getApplicationContext(),Notes.class);
                startActivity(intent1);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=intent.getIntExtra("NOTE_ID",-1);
                Intent intent2=new Intent(getApplicationContext(), Edit.class);
                intent2.putExtra("NOTE_ID",id);
                startActivity(intent2);
            }
        });
    }
}