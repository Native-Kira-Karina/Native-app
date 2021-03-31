package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class enter extends AppCompatActivity {
    ImageButton arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter);
        arrow = (ImageButton) findViewById(R.id.arrow);
        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(enter.this, first.class);
                startActivity(i);
            }
        };
        arrow.setOnClickListener(clickarrow);
    }
}