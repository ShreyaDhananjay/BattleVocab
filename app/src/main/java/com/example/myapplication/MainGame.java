package com.example.myapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainGame
{
    public int []points;
    public ArrayList <String> list=new ArrayList<String>();
    Dictionary d;

    public MainGame()throws IOException
    {
        d=new Dictionary();
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
        int index;
        if(count[0]==1)
        {
            if(d.contains(w))
            {
                points[0] += w.length();
                index=list.indexOf(w);
                if(index!=-1)
                 list.add(w);
                else

                count[0]++;

            }


        }
        else if(count[0]==2)
        {
            if(d.contains(w))
            {
                points[1] += w.length();
                list.add(w);
                count[0]--;

            }

        }
    }//end of processWord

    public void errorMessage(int code, int pt)
    {
        String err;
        switch(code)
        {
            case 1: err="Enter a valid word"; break;
            case 2: err="Word already played! Enter another one"; break;
            case 3: err="Time's up!"; break;
            //default: err="You get "+ pt+" points";
        }

    }
}//end of class



