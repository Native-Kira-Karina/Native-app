package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CheckNumber extends AppCompatActivity {
    ImageButton arrow;
    Button sent, next;
    EditText phone, cod;
    String id, email, password, status, nam, age, inf, help, problem, code;
    private DatabaseReference mDataBase;
    private String UsKey = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_number);

        email = getIntent().getExtras().getString("email");
        password = getIntent().getExtras().getString("password");
        status = getIntent().getExtras().getString("status");
        nam = getIntent().getExtras().getString("nam");
        age = getIntent().getExtras().getString("age");
        inf = getIntent().getExtras().getString("inf");
        help = getIntent().getExtras().getString("help");
        problem = getIntent().getExtras().getString("problem");
        code = getIntent().getExtras().getString("cod");

        mDataBase = FirebaseDatabase.getInstance("https://native-kira-default-rtdb.europe-west1.firebasedatabase.app/").getReference(UsKey);
        id = mDataBase.getKey();

        arrow = (ImageButton) findViewById(R.id.arrow);
        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(CheckNumber.this, First.class);
                startActivity(i);
            }
        };

        phone = findViewById(R.id.phone);
        next = (Button) findViewById(R.id.next);
        View.OnClickListener clnext = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(phone.getText().toString())) {
                    String phoneNum = "+7" + phone.getText().toString();
                    User newUser = new User(id, email, password, status, nam, age, inf, help, problem, phoneNum, code);
                    mDataBase.push().setValue(newUser);
                    Intent i;
                    i = new Intent(CheckNumber.this, Main.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Введите номер телефона", Toast.LENGTH_SHORT).show();
                }
            }
        };
        arrow.setOnClickListener(clickarrow);
        next.setOnClickListener(clnext);

    }
}