package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First extends AppCompatActivity {
    private EditText edit_log, edit_pas;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        init();

    }

    private void init() {
        edit_log = findViewById(R.id.edit_log);
        edit_pas = findViewById(R.id.edit_pas);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.registration).setOnClickListener(v -> onClickReg());
        findViewById(R.id.recovery).setOnClickListener(v -> onClickSignIn());
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if (cUser != null) {
            Toast.makeText(this, "Пользователь зарегестрирован", Toast.LENGTH_SHORT).show();
            cUser.reload();
        }

    }

    public void onClickReg() {
        Log.d("first onClickReg", "-> " + edit_log.getText() + " _ " + edit_pas.getText());
        if (!TextUtils.isEmpty(edit_log.getText().toString()) && !TextUtils.isEmpty(edit_pas.getText().toString())) {
            mAuth.createUserWithEmailAndPassword(edit_log.getText().toString(), edit_pas.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(First.this, "Пользователь успешно зарегестрирован", Toast.LENGTH_SHORT).show();
                        Intent i;
                        i = new Intent(First.this, Reg.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(First.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Введите Email и пароль", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClickSignIn() {
        Log.d("first onClickSignIn", "-> " + edit_log.getText() + " _ " + edit_pas.getText());
        if (!TextUtils.isEmpty(edit_log.getText().toString()) && !TextUtils.isEmpty(edit_pas.getText().toString())) {
            mAuth.signInWithEmailAndPassword(edit_log.getText().toString(), edit_pas.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(First.this, "Пользователь успешно вошёл", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(First.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}