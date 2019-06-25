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
//import com.example.battlevocab.MainGame;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText word1, word2;
    private TextView t1, t2;
    private LinearLayout l1, l2;
    private Button b1, b2;
    public int count;
    MainGame mg;

    public MainActivity() {
        mg = new MainGame();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // word1=(EditText) findViewById(R.id.editText6);
        //word2=(EditText) findViewById(R.id.editText7);
       // l1=(LinearLayout) findViewById(R.id.linearLayout);
        //l2=(LinearLayout) findViewById(R.id.linearLayout3);
        b1=(Button)findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button4);
        b2.setOnClickListener(this);
        
    }
    @Override
    public void onClick(View view)
    {
        String w= new String();
        if(view == b1)
        {
            count=1;
            w=word1.getText().toString();
            mg.processWord(count,w);
        }
        else if(view==b2)
        {
            count=2;
            w=word2.getText().toString();
            mg.processWord(count,w);
        }
    }

    
}