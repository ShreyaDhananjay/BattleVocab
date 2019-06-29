package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

import java.io.IOException;


public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText word1, word2;
    private TextView t1, t2;
    private LinearLayout l1, l2;
    private Button b1, b2;
    String res;
    public int [] count=new int[1];//so it's a reference variable that automatically gets updated
    MainGame mg;
    Winner win;
    SecondActivity sa;

    public ThirdActivity() throws IOException {
        mg = new MainGame();
        sa=new SecondActivity();
        win=new Winner();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        word1 = (EditText) findViewById(R.id.editText6);
        word2 = (EditText) findViewById(R.id.editText7);
        t1= (TextView) findViewById(R.id.textView2);
        t2= (TextView) findViewById(R.id.textView3);
        b1 = (Button) findViewById(R.id.button3);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button4);
        b2.setOnClickListener(this);
        setContentView(R.layout.activity_main);


        //set text w/ names of players
        String s1=sa.s[0];
        t1.setText(s1);
        s1=sa.s[1];
        t2.setText(s1);
    }

    @Override
    public void onClick(View view)
    {
        String w;
        if (view == b1)
        {
            count[0] = 1;
            w = word1.getText().toString();

            if (w.length() == 0)
            {
                word1.requestFocus();
                word1.setError("Enter a word");
            }

            else if(!mg.processWord(count,w))
            {
                word1.requestFocus();
                word1.setError("Invalid Word");
            }

            //fetch name of winner
            res=win.checkWinner(mg.points[0], sa.pts, 1);

            //if person has won
            if(res!=null)
                startActivity(new Intent(this, FourthActivity.class));

        }

        else if (view == b2)
        {
            count[0] = 2;
            w = word2.getText().toString();
            if (w.length() == 0)
            {
                word2.requestFocus();
                word2.setError("Enter a word");
            }

            else if(!mg.processWord(count,w))
            {
                word2.requestFocus();
                word2.setError("Invalid word!");
            }

            //fetch name of winner
            res=win.checkWinner(mg.points[0], sa.pts, 2);

            //if person has won
            if(res!=null)
                startActivity(new Intent(this, FourthActivity.class));

        }
    }
}