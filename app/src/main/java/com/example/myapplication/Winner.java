package com.example.myapplication;

public class Winner
{
    SecondActivity sa;

    public Winner() {
        sa = new SecondActivity();
    }

    public String checkWinner(int points, int max, int count)
    {
        if(points>=max && count==1)
            return sa.s[0] ;
        else if(points>=max && count==2)
            return sa.s[1];
        else
            return sa.s[3];
    }
}
