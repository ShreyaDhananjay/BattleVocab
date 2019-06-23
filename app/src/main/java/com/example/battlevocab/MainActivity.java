package com.example.battlevocab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText word1, word2;
    private TextView t1, t2;
    private LinearLayout l1, l2;
    private Button b1, b2;
    public int count;
    public int []points;
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
        b1=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button4);
        b2.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        if(view == b1)
        {
            count=1;
            processWord();
        }
        else if(view==b2)
        {
            count=2;
            processWord();
        }
    }

    private void processWord()
    {
        String w=new String();
        if(count==1)
        {
            w=word1.getText().toString();
            points[0]+=w.length();
        }

        else if(count==2)
        {
            w=word2.getText().toString();
            points[1]+=w.length();
        }
    }
}