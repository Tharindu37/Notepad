package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.txtName);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.setText("N");
            }
        },500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("o");
            }
        },700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("t");
            }
        },900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("e");
            }
        },1100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("P");
            }
        },1300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("a");
            }
        },1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("d");
            }
        },1700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Notes.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

}