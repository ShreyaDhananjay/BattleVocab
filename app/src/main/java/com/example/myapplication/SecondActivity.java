package com.example.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

@SuppressLint("Registered")
public class SecondActivity extends AppCompatActivity {

    EditText e1, e2, e3;//e1 for player 1 name, e2 for player 2, e3 for max points
    Button b1;
    public String []s=new String[3];
    public int pts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        e1=(EditText)findViewById(R.id.editText9);
        e2=(EditText)findViewById(R.id.editText10);
        e3=(EditText)findViewById(R.id.editText11);
        b1=(Button)findViewById(R.id.button5);

        s[0]=e1.getText().toString();//player 1 name
        s[1]=e2.getText().toString();//player 2 name
        s[2]=e3.getText().toString();
        pts=Integer.parseInt(s[2]);//max points
    }
}
