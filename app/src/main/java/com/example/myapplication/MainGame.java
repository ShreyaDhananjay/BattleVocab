package com.example.myapplication;

import java.util.Random;

public class MainGame
{
    public int []points;
    public char randomLetterGen()
    {
        String s="abcdefghijklmnopqrstuvwxyz";
        Random r=new Random();
        int n=s.length();
        char c=s.charAt(r.nextInt(n));
        return c;
    }

    public void processWord(int count, String w)
    {
        if(count==1)
        {
            points[0]+=w.length();
            count++;

        }
        else if(count==2)
        {
            points[1]+=w.length();
            count--;
        }
    }
}



