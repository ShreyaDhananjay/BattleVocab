package com.example.myapplication;

import java.io.IOException;

public class Winner
{

    public int checkWinner(int points, int max, int count)
    {
        if(points>=max && count==1)
            return 1 ;
        else if(points>=max && count==2)
            return 2;
        else
            return 3;
    }
}
