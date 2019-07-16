package com.example.myapplication;

import java.util.Random;

public class LetterGenerator

{
    public char randomLetterGen()
    {
        String s="ABCDEFGHIJKLMNOPQRSTUVWYZ";
        Random r=new Random();
        int n=s.length();
        char c=s.charAt(r.nextInt(n));
        return c;
    }
}

