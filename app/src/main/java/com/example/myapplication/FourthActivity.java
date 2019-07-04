package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class FourthActivity extends AppCompatActivity implements OnClickListener
{
    private TextView t;
    ThirdActivity ta;
    Button b1, b2;

    public FourthActivity() throws IOException {
        ta = new ThirdActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        t=(TextView)findViewById(R.id.textView6);
        t.setText(ta.res);
        b1=(Button)findViewById(R.id.button6);
        b2=(Button) findViewById(R.id.button7);
    }

    @Override
    public void onClick(View view)
    {
        if(view==b1)
            startActivity(new Intent(this, SecondActivity.class));
        else if(view==b2)
            startActivity(new Intent(this, MainActivity.class));
    }

}
