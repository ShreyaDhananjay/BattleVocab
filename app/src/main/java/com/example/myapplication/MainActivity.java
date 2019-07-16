package com.example.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTextMessage;
    private Button b1, b, b2;
    /*private BottomNavigationView mBottomNavigationView;


   private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                     return true;
               case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        ///mTextMessage = findViewById(R.id.message);
        //navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);

    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void goToFifthActivity()
    {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);

    }
    private void goToInstructionsActivity() {
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        if(v==b1)
            goToSecondActivity();
        else if(v==b)
            goToFifthActivity();
        else if(v==b2)
            goToInstructionsActivity();
    }

   }
