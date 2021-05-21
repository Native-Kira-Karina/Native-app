package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AnkGrany extends AppCompatActivity {
    ImageButton arrow;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anketa_grany);
        arrow = (ImageButton) findViewById(R.id.arrow);
        next = (Button) findViewById(R.id.SignUp);
        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(AnkGrany.this, Reg.class);
                startActivity(i);
            }
        };
        View.OnClickListener clnext = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(AnkGrany.this, CheckNumber.class);
                startActivity(i);
            }
        };
        arrow.setOnClickListener(clickarrow);
        next.setOnClickListener(clnext);
    }
}
