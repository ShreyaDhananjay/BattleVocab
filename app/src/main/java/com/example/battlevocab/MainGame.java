package com.example.battlevocab;

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

    public void processWord(int count)
    {
        String w=new String();
        if(count==1)
        {
            w=word1.getText().toString();
            points[0]+=w.length();
        }
        else if(count==2)
        {
            w=word2.getText().toString();
            points[1]+=w.length();
        }
    }
}


}
