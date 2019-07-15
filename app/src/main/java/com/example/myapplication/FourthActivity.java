package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class FourthActivity extends AppCompatActivity implements OnClickListener
{
    private TextView t5, t6;
   // ThirdActivity ta;
    Button b1, b2, b3;
    String win="", msg="";
    char c;
    /*public FourthActivity() throws IOException {
        ta = new ThirdActivity();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);
        //t.setText(ta.res);
        b1=(Button)findViewById(R.id.button6);
        b1.setOnClickListener(this);
        b2=(Button) findViewById(R.id.button7);
        b2.setOnClickListener(this);
        //b3=(Button)findViewById(R.id.button2);
        //b3.setOnClickListener(this);
        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        win=bundle.getString("winner");
        c=bundle.getChar("mode");
        if(c=='s')
            msg=bundle.getString("message");
        set();
        //updateTextView();
    }

    @Override
    public void onClick(View view)
    {
        if(view==b1&& c=='m')
            startActivity(new Intent(this, SecondActivity.class));
        else if(view==b1 && c=='s')
            startActivity(new Intent(this, SixthActivity.class));
        else if(view==b2)
            startActivity(new Intent(this, MainActivity.class));
        /*else if(view==b3)
        {
            t.setText(win);
        }*/
    }
    private void updateTextView() {
        FourthActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView tv= (TextView) findViewById(R.id.textView6);
                tv.setText(win);
            }
        });

    }
    public void set()
    {
        t6.setText(win);
        if(c=='s')
          t5.setText(msg);
    }

}
