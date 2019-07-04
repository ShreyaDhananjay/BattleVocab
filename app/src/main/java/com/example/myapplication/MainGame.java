package com.example.myapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainGame
{
    public int []points;
    public ArrayList <String> list=new ArrayList<String>();
    Dictionary d;
    ThirdActivity ta1;
    TimerClass tc;
    boolean flag=false;

    public MainGame()throws IOException
    {
        d=new Dictionary();
        ta1=new ThirdActivity();
        tc=new TimerClass();
    }

    public char randomLetterGen()
    {
        String s="abcdefghijklmnopqrstuvwxyz";
        Random r=new Random();
        int n=s.length();
        char c=s.charAt(r.nextInt(n));
        return c;
    }

    public void processWord(int []count, String w)
    {
        int index,list_size, prev_length;
        String prev;
        boolean flag=false;
        if(d.contains(w))//a valid dictionary word
        {
            list_size = list.size();
            index = list.indexOf(w);
            prev = list.get(list_size - 1);
            prev_length = prev.length();
            if (w.charAt(0) == prev.charAt(prev_length - 1))//if last letter of previous word is the starting letter of next word//
            {
                if (index == -1)//new word entered
                {
                    list.add(w);
                    flag = true;//no error

                    if(count[0]==1)
                    {
                        points[0]+=w.length();
                        ta1.setPoints(1, points[0]);
                    }

                    else
                    {
                        points[1]+=w.length();
                        ta1.setPoints(2, points[1]);
                    }
                }

                else//word starts w/ correct letter but has already been entered
                    errorMessage(1);
            }

            else//word starts w/ wrong letter
                errorMessage(2);

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
        switch(code)
        {
            case 1: err="Word already played! Enter another one"; flag=true; break;
            case 2: err="The word must start with the last letter of the previous word"; flag=true; break;
            case 3: err="The word does not belong in the dictionary";flag=true; break;
            case 4: err="Time's up!";flag=true; break;
            //default: err="You get "+ pt+" points";
        }
        ta1.dispError(err,flag);
    }

    public void stopTimer(boolean flag)
    {
        if(flag)
            tc.stop();//stop timer
    }
}//end of class



