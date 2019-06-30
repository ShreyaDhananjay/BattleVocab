package com.example.myapplication;
import java.util.Timer;
import java.util.TimerTask;

public class TimerClass
{
    int secondspassed;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondspassed++;
            if (secondspassed == 20) {
                System.out.println("Time's up!");
                cancel();
                //start();
            }
        }
    };

    public void start() {
        secondspassed = 0;
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
}//end of class


