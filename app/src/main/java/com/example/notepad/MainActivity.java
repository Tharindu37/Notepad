package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        },800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("t");
            }
        },1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("e");
            }
        },1200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("P");
            }
        },1400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("a");
            }
        },1600);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                name.append("d");
            }
        },1800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Notes.class);
                startActivity(intent);
                finish();
            }
        },3500);
    }

}