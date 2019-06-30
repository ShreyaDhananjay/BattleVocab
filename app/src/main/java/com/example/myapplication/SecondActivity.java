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

import java.io.IOException;

@SuppressLint("Registered")
public class SecondActivity extends AppCompatActivity {

    EditText e1, e2, e3;//e1 for player 1 name, e2 for player 2, e3 for max points
    Button b1,b2;
    PopupWindow popupWindow;
    LinearLayout linearLayout;
    TextView tv;
    public String []s=new String[4];
    public int pts;
    MainGame mainGame;
    char c;

    public SecondActivity() throws IOException {
        mainGame = new MainGame();
    }

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
        s[3]=null;
        c=mainGame.randomLetterGen();
        final String disp=s[0]+"will start the game. Make the first word with the letter ' "+c+" '\nYour time starts now! ";
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout1);//of popup.xml

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //instantiate the popup.xml layout file
                LayoutInflater layoutInflater = (LayoutInflater) SecondActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup,null);

                b2 = (Button) customView.findViewById(R.id.closePopupBtn);

                //instantiate popup window
                popupWindow = new PopupWindow(customView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                tv=(TextView)popupWindow.getContentView().findViewById(R.id.textView1);

                //display the popup window
                tv.setText(disp);
                popupWindow.showAtLocation(linearLayout, Gravity.CENTER, 0, 0);

                //close the popup window on button click
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        goToNextActivity();
                    }
                });

            }
        });

    }

    public void goToNextActivity()
    {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}


