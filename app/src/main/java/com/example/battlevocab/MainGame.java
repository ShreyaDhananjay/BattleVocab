package com.example.battlevocab;

import java.util.Random;

public class MainGame
{
    public int []points=new int[2];
    public char randomLetterGen()
    {
        String s = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        int n = s.length();
        return s.charAt(r.nextInt(n));
    }

    public void processWord(int count, String w)
    {
        if(count==1)
        {
            points[0]+=w.length();
        }
        else if(count==2)
        {
            points[1]+=w.length();
        }
    }
}


