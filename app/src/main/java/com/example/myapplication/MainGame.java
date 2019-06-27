package com.example.myapplication;

import java.io.IOException;
import java.util.Random;

public class MainGame
{
    public int []points;
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

    public boolean processWord(int []count, String w)
    {
        if(count[0]==1)
        {
            if(d.contains(w))
            {
                points[0] += w.length();
                count[0]++;
                return true;
            }
            else
                return false;
        }
        else if(count[0]==2)
        {
            if(d.contains(w))
            {
                points[1] += w.length();
                count[0]--;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
}



