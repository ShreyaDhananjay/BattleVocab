package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FifthActivity extends AppCompatActivity implements View.OnClickListener {

    Button b8, b9, b10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        b8=(Button)findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9=(Button)findViewById(R.id.button9);
        b9.setOnClickListener(this);
        b10=(Button)findViewById(R.id.button10);
        b10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        goToSixthActivity();
    }

    private void goToSixthActivity() {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);

    }
}
