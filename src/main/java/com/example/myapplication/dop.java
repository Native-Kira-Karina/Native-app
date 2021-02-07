package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class dop extends AppCompatActivity {
    TextView txt;
    EditText etxt;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dop);
        // инициализируем переменные объектами связанными с ID виджетов
        txt = (TextView)findViewById(R.id.txt1);
        etxt = (EditText)findViewById(R.id.etxt1);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
    }
}
public class MainActivity extends AppCompatActivity {
    //объявляем переменные для компонентов (виджетов)
    TextView txt;
    EditText etxt;
    Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // инициализируем переменные объектами связанными с ID виджетов
        txt = (TextView)findViewById(R.id.txt1);
        etxt = (EditText)findViewById(R.id.etxt1);
        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);