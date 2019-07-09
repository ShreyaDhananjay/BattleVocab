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


public class ThirdActivity extends AppCompatActivity {

    private EditText word1, word2;
    private TextView t1, t2, t3, t4;
    private LinearLayout l1, l2;
    private Button b1, b2;
    public ArrayList<String> word_list=new ArrayList<String>();
    public ArrayList <String> list=new ArrayList<String>();
    int res, maxpts=50, counter=0;
    int [] points=new int[2];
    public int [] count=new int[1];//so it's a reference variable that automatically gets updated
    char c;
    String s1="",s2="", disp="";
    String []data=new String[3];
   // MainGame mg;
    Winner win;
    //SecondActivity sa;
    TimerClass tc;
    //Dictionary d;

    public ThirdActivity() throws IOException {
      //  mg = new MainGame();
       // sa=new SecondActivity();
        win=new Winner();
        tc=new TimerClass();
        //d=new Dictionary();
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
        /*tc.start();//start timer
        */

    }//end of onCreate

    public boolean contain(String word)
    {
        return (java.util.Collections.binarySearch(word_list, word) > 0);
        //return wordsSet.contains(word);
    }


    public void processWord(int []count, String w, int []points)
    {
        int index,list_size, prev_length;
        String prev;
        boolean flag=false;
        String s=w.toUpperCase();
        if(contain(s))//a valid dictionary word
        {
            if(!(counter==1))
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
                            disp=s1+" gets "+String.valueOf(s.length())+ " points";
                            noError(disp);
                            points[0]+=s.length();
                        }

                        else
                         {
                             disp=s2+" gets "+String.valueOf(s.length())+ " points";
                             noError(disp);
                             points[1]+=s.length();
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

                    if (count[0] == 1)
                    {
                        disp = s1 + " gets " + String.valueOf(s.length()) + " points";
                        noError(disp);
                        points[0] += s.length();
                    }
                    else if (count[0] == 2)
                    {
                        disp = s2 + " gets " + String.valueOf(s.length()) + " points";
                        noError(disp);
                        points[1] += s.length();
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
            stopTimer(flag);
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
                flag = true;
                break;
            case 2:
                err = "The word must start with the last letter of the previous word";
                counter--;
                flag = true;
                break;
            case 3:
                err = "The word does not belong in the dictionary";
                counter--;
                flag = true;
                break;
            case 4:
                err = "Time's up!";
                counter--;
                flag = true;
                break;
            //default: err="You get "+ pt+" points";
        }
        if(flag)
            Toast.makeText(getApplicationContext(), err,Toast.LENGTH_SHORT ).show();

    }

    public void stopTimer(boolean flag)
    {
        if(flag)
            tc.stop();//stop timer
    }

    private View.OnClickListener vocl1 = new View.OnClickListener()
    {

        @Override
        public void onClick(View v)
        {
            t1.setText(s1);
            String w;
            count[0] = 1;
            counter++;
            w = word1.getText().toString();
            System.out.println(w);
            processWord(count, w, points);
            word2.setText("");
            setPoints();
            //fetch name of winner
            res = win.checkWinner(points[0], maxpts, 1);
            //for debugging
            //String temp= String.valueOf(res);
            //Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
            //dispError(temp, true);
            //if person has won
            if (res == 1 || res == 2)
                goToFourthActivity();

        }
    };

    private View.OnClickListener vocl2=new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            t2.setText(s2);
            String w;
            count[0] = 2;
            counter++;
            w = word2.getText().toString();
            processWord(count, w, points);
            word1.setText("");
            setPoints();
            //fetch name of winner
            res=win.checkWinner(points[1], maxpts, 2);

            //if person has won
            if(res==1 || res==2)
                goToFourthActivity();

        }
    };

    public void goToFourthActivity()
    {
        Intent intent=new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void noError(String e)
    {
        Toast toast=Toast.makeText(getApplicationContext(), e,Toast.LENGTH_SHORT );
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0,0);
        toast.show();

    }
    //no need for this right now as setText() is not quick
    public void setPoints()
    {
        String dispmsg1="";
        String dispmsg2="";
        if(count[0]==1)
        {
            dispmsg1=String.valueOf(points[0])+" POINTS";
            t3.setText(dispmsg1);
        }

        else if(count[0]==2)
        {
            dispmsg2=String.valueOf(points[1])+" POINTS";
            t4.setText(dispmsg2);

        }
    }
}