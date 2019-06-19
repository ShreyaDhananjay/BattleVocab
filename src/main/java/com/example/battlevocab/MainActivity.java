package com.example.battlevocab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText word1, word2;
    private TextView t1, t2;
    private LinearLayout l1, l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word1=(EditText) findViewById(R.id.editText6);
        word2=(EditText) findViewById(R.id.editText7);
        t1=(TextView) findViewById(R.id.textView2);
        t2=(TextView) findViewById(R.id.textView3);
        l1=(LinearLayout) findViewById(R.id.linearLayout);
        l2=(LinearLayout) findViewById(R.id.linearLayout3);
    }
}
