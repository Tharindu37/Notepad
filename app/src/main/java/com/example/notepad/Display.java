package com.example.notepad;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notepad.model.Note;

public class Display extends AppCompatActivity {

    private TextView title;
    private TextView date;
    private TextView description;
    private ImageButton delete;
    private ImageButton edit;
    private ImageButton close;

    private ImageButton share;

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
        close=findViewById(R.id.btnCloseNote);
        share=findViewById(R.id.btnShareNote);

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
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
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

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(), Notes.class);
                startActivity(intent1);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=intent.getIntExtra("NOTE_ID",-1);

                Note note=dbHandler.getSingleNote(id);
                shareText(note.getTitle()+"\n"+note.getDate()+"\n"+note.getNote());
            }
        });


    }
    private void shareText(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(shareIntent, "Share text using"));
    }
}