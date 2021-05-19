package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class CheckNumber extends AppCompatActivity {
    ImageButton arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_number);
        arrow = (ImageButton) findViewById(R.id.arrow);
        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(CheckNumber.this, First.class);
                startActivity(i);
            }
        };
        arrow.setOnClickListener(clickarrow);

    }
}