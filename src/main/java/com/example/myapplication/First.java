package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First extends AppCompatActivity {
    Button recovery, registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        recovery = (Button) findViewById(R.id.recovery);
        registration = (Button) findViewById(R.id.registration);
        View.OnClickListener on = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(First.this, Enter.class);
                startActivity(i);
            }
        };
        View.OnClickListener on2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(First.this, Reg.class);
                startActivity(i);
            }
        };
        recovery.setOnClickListener(on);
        registration.setOnClickListener(on2);
        }
    }