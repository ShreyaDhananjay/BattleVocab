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
    private TextView t1, t2, t3, t4;
    private LinearLayout l1, l2;
    private Button b1, b2;
    String res;
    public int [] count=new int[1];//so it's a reference variable that automatically gets updated
    MainGame mg;
    Winner win;
    SecondActivity sa;
    TimerClass tc;

    public ThirdActivity() throws IOException {
        mg = new MainGame();
        sa=new SecondActivity();
        win=new Winner();
        tc=new TimerClass();
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
        t3= (TextView) findViewById(R.id.textView4);
        t4= (TextView) findViewById(R.id.textView7);
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

        tc.start();//start timer


    }//end of onCreate

    @Override
    public void onClick(View view)
    {
        String w;
        if (view == b1)
        {
            count[0] = 1;
            w = word1.getText().toString();
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

            //fetch name of winner
            res=win.checkWinner(mg.points[0], sa.pts, 2);

            //if person has won
            if(res!=null)
                startActivity(new Intent(this, FourthActivity.class));


        }
    }

    public void dispError(String e, boolean flag)
    {
        if(flag)
            Toast.makeText(getApplicationContext(), e,Toast.LENGTH_SHORT ).show();
    }

    public void setPoints(int check, int pts)
    {
        String dispmsg;
        if(check==1)
        {
            dispmsg=pts+" POINTS";
            t3.setText(dispmsg);
        }

        else
        {
            dispmsg=pts+" POINTS";
            t4.setText(dispmsg);
        }
    }
}