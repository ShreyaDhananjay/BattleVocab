package com.example.myapplication;
import java.util.Timer;
import java.util.TimerTask;

public class timer{
    int secondspassed;
    Timer timer=new Timer();
    TimerTask task=new TimerTask() {
        public void run()
        {
            secondspassed++;
            if(secondspassed==10){
            System.out.println("seconds Passed:" + secondspassed);
             cancel();
             start();
            }

        }
    };
    public void start(){
         secondspassed=0;
       timer.scheduleAtFixedRate(task,1000,1000);
    }


public static void main(String[] args)
{
timer project=new timer();
project.start();
} 

}