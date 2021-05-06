package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Reg extends AppCompatActivity {
    ImageButton arrow, famy, grany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        arrow = (ImageButton) findViewById(R.id.arrow);
        famy = (ImageButton) findViewById(R.id.famy);
        grany = (ImageButton) findViewById(R.id.grany);
        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Reg.this, First.class);
                startActivity(i);
            }
        };
        View.OnClickListener clickfamy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Reg.this, AnkFamy.class);
                startActivity(i);
            }
        };
        View.OnClickListener clickgrany = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(Reg.this, AnkGrany.class);
                startActivity(i);
            }
        };
        arrow.setOnClickListener(clickarrow);
        famy.setOnClickListener(clickfamy);
        grany.setOnClickListener(clickgrany);


    }
}