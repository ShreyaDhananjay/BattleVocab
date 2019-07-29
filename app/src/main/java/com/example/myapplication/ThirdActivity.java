package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class ThirdActivity extends AppCompatActivity {

    private EditText word1, word2;
    private TextView t1, t2, t3, t4;
    private LinearLayout l1, l2;
    private Button b1, b2;
    public ArrayList<String> word_list=new ArrayList<String>();
    public ArrayList <String> list=new ArrayList<String>();
    int res, maxpts=50, counter=0, secondspassed;
    int [] points=new int[2];
    public int [] count=new int[1];//so it's a reference variable that automatically gets updated
    char c;
    boolean error_flag=false;//will be true if word entered is wrong
    String s1="",s2="", disp="", winnername;
    String []data=new String[3];
    Winner win;



    public ThirdActivity() throws IOException {

       // sa=new SecondActivity();
        win=new Winner();
        count[0]=1;

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
        b1.setOnClickListener(vocl1);
        b2 = (Button) findViewById(R.id.button4);
        b2.setOnClickListener(vocl2);
        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        data=bundle.getStringArray("user_data");
        c=bundle.getChar("starting char");
        s1=data[0];//player 1 name
        s2=data[1];
        if(!data[2].equals(""))
            maxpts=Integer.parseInt(data[2]);//max points
        updateTextView(s1, 1);
        updateTextView(s2,2);
        System.out.println("Max pts: "+maxpts+"start char: "+c);

        AssetManager assetManager=getAssets();
        try
        {
            //Context context=this;
           // d.readWordList(assetManager);
            InputStream inputStream=assetManager.open("wordlist3.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=br.readLine())!=null)
            {
                String word=line.trim();
                word_list.add(word);
            }
            System.out.println(java.util.Collections.binarySearch(word_list, "HOUSE"));
        }

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR LOADING DICTIONARY");
        }
        //start();//start timer


    }//end of onCreate

    public boolean contain(String word)
    {
        return (java.util.Collections.binarySearch(word_list, word) >= 0);
        //return wordsSet.contains(word);
    }


    public void processWord(String w)
    {
        int index,list_size, prev_length;
        String prev;
        boolean flag=false;
        String s=w.toUpperCase();
        if(contain(s))//a valid dictionary word
        {
            if(counter>1)//not the first time
            {
                //System.out.println(counter);
                list_size = list.size();
                index = list.indexOf(s);
                prev = list.get(list_size - 1);
                System.out.println(prev);
                prev_length = prev.length();

                if (s.charAt(0) == prev.charAt(prev_length - 1))//if last letter of previous word is the starting letter of next word//
                {
                    if (index == -1)//new word entered
                    {
                        list.add(s);
                        flag = true;//no error

                        if(count[0]==1)
                        {
                            points[0]+=s.length();
                            error_flag=false;
                            //stopTimer(flag);
                        }

                        else
                         {
                             points[1]+=s.length();
                             error_flag=false;
                             //stopTimer(flag);
                         }
                    }

                    else//word starts w/ correct letter but has already been entered
                        errorMessage(1);
                }

                else//word starts w/ wrong letter
                    errorMessage(2);
            }//end of second most outer if
           // System.out.println("YAY");

            else//first word that's been played
            {
                if (s.charAt(0) == c)
                {
                    System.out.println("first time");
                    list.add(s);
                    flag=true;
                    if (count[0] == 1)
                    {
                        points[0] += s.length();
                        error_flag=false;
                        //stopTimer(true);
                    }
                    else if (count[0] == 2)
                    {
                        points[1] += s.length();
                        error_flag=false;
                        //stopTimer(true);
                    }
                }

                else//first word starts w/ wrong letter
                    errorMessage(2);
            }

        }//end of outermost if

        else//not a valid word
            errorMessage(3);

        if(flag)
        {
            //stopTimer(flag);
            if(count[0]==1)
                count[0]++;
            else
                count[0]--;
        }

    }//end of processWord
    public void errorMessage(int code)
    {
        String err="";
        boolean flag=false;
        switch(code) {
            case 1:
                err = "Word already played! Enter another one";
                counter--;
                //flag = true;
                error_flag=true;
                break;
            case 2:
                err = "The word must start with the last letter of the previous word";
                counter--;
                //flag = true;
                error_flag=true;
                break;
            case 3:
                err = "The word does not belong in the dictionary";
                counter--;
                //flag = true;
                error_flag=true;
                break;
            case 4:
                err = "Time's up!\nYour turn has passed";
                counter--;
                //dispTimerMessage(err);
                break;
            //default: err="You get "+ pt+" points";
        }
        //if(flag)
            Toast.makeText(getApplicationContext(), err,Toast.LENGTH_SHORT ).show();

    }
/*
    public void stopTimer(boolean flag)
    {
        if(flag)
            stop();//stop timer
    }*/

    private View.OnClickListener vocl1 = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            if(count[0]==1) {
                t1.setText(s1);
                String w, dispmsg1;
                //count[0] = 1;
                counter++;
                w = word1.getText().toString();
                System.out.println(w);
                processWord(w);
                word2.setText("");
                dispmsg1 = points[0] + " POINTS";
                t3.setText(dispmsg1);
                if (!error_flag) {
                    word2.requestFocus();
                    //stop();
                }
                //fetch name of winner
                res = win.checkWinner(points[0], maxpts, 1);

                //if person has won
                if (res == 1 || res == 2) {
                    //stopTimer(true);
                    goToFourthActivity();
                }
            }//end of if
            else
                Toast.makeText(getApplicationContext(), "NOT YOUR TURN", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener vocl2=new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
           if(count[0]==2) {
               t2.setText(s2);
               String w, dispmsg2;
               //count[0] = 2;
               counter++;
               w = word2.getText().toString();
               processWord(w);
               word1.setText("");
               dispmsg2 = points[1] + " POINTS";
               t4.setText(dispmsg2);
               if (!error_flag) {
                   word1.requestFocus();
                   //stop();
               }
               //fetch name of winner
               res = win.checkWinner(points[1], maxpts, 2);

               //if person has won
               if (res == 1 || res == 2) {
                   //stopFully();
                   goToFourthActivity();
               }
           }//end of if
           else
            Toast.makeText(getApplicationContext(), "NOT YOUR TURN", Toast.LENGTH_SHORT).show();
        }
    };

    public void goToFourthActivity()
    {
        Intent intent=new Intent(this, FourthActivity.class);
        if(res==1)
            winnername=s1.toUpperCase()+" WINS";
        else
            winnername=s2.toUpperCase()+ " WINS";
        char mode='m';
        Bundle b=new Bundle();
        b.putString("winner", winnername);
        b.putChar("mode", mode);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void noError(String e)
    {
        Toast toast=Toast.makeText(getApplicationContext(), e,Toast.LENGTH_SHORT );
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0,0);
        toast.show();

    }
/*

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondspassed++;
            if (secondspassed == 5)
            {
                errorMessage(4);
                System.out.println("Time's up!");
                cancel();
                //start();
            }
        }
    };


    public void start()
    {
        secondspassed = 0;
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }


    public void stop()
    {
        timer.cancel();
        timer=new Timer();
        secondspassed=0;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                secondspassed++;
                if (secondspassed == 5) {
                    ThirdActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast toast = Toast.makeText(getApplicationContext(), "Time's Up", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
                            toast.show();
                        }
                    });
                    stop();
                }
            }

        }, 1000, 1000);
    }
    public void stopFully()
    {
        timer.cancel();
    }

    private void dispTimerMessage(final String msg){
        ThirdActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast=Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0,0);
                toast.show();
            }
        });
    }*/
    private void updateTextView(final String s, final int code) {
        ThirdActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(code==1)
                    t1.setText(s);
                else if(code==2)
                    t2.setText(s);
                else if(code==3)
                    t3.setText(s);
                else if(code==4)
                    t4.setText(s);

            }
        });

    }

}