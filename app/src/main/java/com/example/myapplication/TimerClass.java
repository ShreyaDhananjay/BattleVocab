package com.example.myapplication;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TimerClass
{
    //MainGame m;
    int secondspassed;

    public TimerClass()throws IOException
    {
        //m = new MainGame();
    }

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondspassed++;
            if (secondspassed == 20)
            {
                //m.errorMessage(4);
                //System.out.println("Time's up!");
                cancel();
                //start();
            }
        }
    };


    public void start()
    {
        secondspassed = 0;
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }


    public void stop()
    {
        task.cancel();
    }

}//end of class


