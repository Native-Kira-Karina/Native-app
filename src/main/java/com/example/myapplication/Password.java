package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Password extends AppCompatActivity {
    private EditText edit_log, edit_pas;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        init();

    }
    private void init(){
        edit_log = findViewById(R.id.edit_log);
        edit_pas = findViewById(R.id.edit_pas);

    }
    public void onClickSignUp(View view){

    }
}
