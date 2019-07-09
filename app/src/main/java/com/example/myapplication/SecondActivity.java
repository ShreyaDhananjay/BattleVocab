package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

//@SuppressLint("Registered")
public class SecondActivity extends AppCompatActivity {

    EditText e1, e2, e3;//e1 for player 1 name, e2 for player 2, e3 for max points
    Button b1, b2;
    ThirdActivity thirdActivity;
    //PopupWindow popupWindow=null;
    //LinearLayout linearLayout;
    TextView tv;
    public String[] s = new String[4];
    public int pts;
    LetterGenerator lg;
    char c = 'a';

    public SecondActivity() throws IOException {
        lg=new LetterGenerator();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        e1 = (EditText) findViewById(R.id.editText9);
        e2 = (EditText) findViewById(R.id.editText10);
        e3 = (EditText) findViewById(R.id.editText11);
        b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(vocl);
        s[3] = null;

        c=lg.randomLetterGen();
        //linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);//of popup.xml


    }


    private View.OnClickListener vocl = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {

            s[0]=e1.getText().toString();//player 1 name
            s[1]=e2.getText().toString();//player 2 name
            s[2]=e3.getText().toString();
            if(!s[2].equals(""))
                pts=Integer.parseInt(s[2]);//max points


            final String disp=s[0]+" will start the game. Make the first word with the letter ' "+c+" '\nYour time starts now! Max pts is "+pts;

            Toast toast=Toast.makeText(getApplicationContext(), disp, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();


            goToNextActivity();

        }
    };




    public void goToNextActivity()
    {
        Intent intent=new Intent(this,ThirdActivity.class);
        Bundle bundle=new Bundle();

        bundle.putStringArray("user_data", s);
        bundle.putChar("starting char", c);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}


