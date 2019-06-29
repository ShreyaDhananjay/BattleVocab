package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class FourthActivity extends AppCompatActivity
{
    private TextView t;
    ThirdActivity ta;

    public FourthActivity() throws IOException {
        ta = new ThirdActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        t=(TextView)findViewById(R.id.textView6);
        t.setText(ta.res);
    }
}
