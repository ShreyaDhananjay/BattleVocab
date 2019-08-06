package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FifthActivity extends AppCompatActivity implements View.OnClickListener {

    Button b8, b9, b10;
    int level=0;
    char l='a';
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
    public void onClick(View v)
    {
        if(v==b8)
        {
            level=1;
            l='1';
            String disp="Whoever reaches 50 points first, wins!";
            Toast toast=Toast.makeText(getApplicationContext(), disp, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            goToSixthActivity();
        }
        else if (v==b9)
        {
            level=2;
            l='2';
            String disp="You need 60 points to win, the computer only needs 45!";
            Toast toast=Toast.makeText(getApplicationContext(), disp, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            goToSixthActivity();

        }
        else
        {
            level=3;
            l='3';
            String disp="All words must start with the letter \'W\'";
            Toast toast=Toast.makeText(getApplicationContext(), disp, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
            goToSixthActivity();

        }


    }

    private void goToSixthActivity() {
        Intent intent = new Intent(this, SixthActivity.class);
        Bundle bundle=new Bundle();
        bundle.putInt("level", level);
        //bundle.putChar("level", l);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
