package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Reg extends AppCompatActivity {
    ImageButton arrow, famy, grany;
    String email, password, status, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        arrow = (ImageButton) findViewById(R.id.arrow);
        famy = (ImageButton) findViewById(R.id.famy);
        grany = (ImageButton) findViewById(R.id.grany);

        email = getIntent().getStringExtra("email");
        id = getIntent().getStringExtra("id");
        password = getIntent().getStringExtra("password");

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
                status = "famy";
                i = new Intent(Reg.this, AnkFamy.class);
                i.putExtra("email", email);
                i.putExtra("email", email);
                i.putExtra("id", id);
                i.putExtra("status", status);
                startActivity(i);
            }
        };
        View.OnClickListener clickgrany = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                status = "grany";
                i = new Intent(Reg.this, AnkGrany.class);
                i.putExtra("email", email);
                i.putExtra("id", id);
                i.putExtra("password", password);
                i.putExtra("status", status);
                startActivity(i);
            }
        };
        arrow.setOnClickListener(clickarrow);
        famy.setOnClickListener(clickfamy);
        grany.setOnClickListener(clickgrany);


    }
}