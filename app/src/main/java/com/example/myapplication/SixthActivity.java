package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SixthActivity extends AppCompatActivity {

    public ArrayList<String> word_list1=new ArrayList<String>();
    ArrayList <String> used_words = new ArrayList<String>();
    ArrayList <String> A_Letter = new ArrayList<String>();
    ArrayList <String> B_Letter = new ArrayList<String>();
    ArrayList <String> C_Letter = new ArrayList<String>();
    ArrayList <String> D_Letter = new ArrayList<String>();
    ArrayList <String> E_Letter = new ArrayList<String>();
    ArrayList <String> F_Letter = new ArrayList<String>();
    ArrayList <String> G_Letter = new ArrayList<String>();
    ArrayList <String> H_Letter = new ArrayList<String>();
    ArrayList <String> I_Letter = new ArrayList<String>();
    ArrayList <String> J_Letter = new ArrayList<String>();
    ArrayList <String> K_Letter = new ArrayList<String>();
    ArrayList <String> L_Letter = new ArrayList<String>();
    ArrayList <String> M_Letter = new ArrayList<String>();
    ArrayList <String> N_Letter = new ArrayList<String>();
    ArrayList <String> O_Letter = new ArrayList<String>();
    ArrayList <String> P_Letter = new ArrayList<String>();
    ArrayList <String> Q_Letter = new ArrayList<String>();
    ArrayList <String> R_Letter = new ArrayList<String>();
    ArrayList <String> S_Letter = new ArrayList<String>();
    ArrayList <String> T_Letter = new ArrayList<String>();
    ArrayList <String> U_Letter = new ArrayList<String>();
    ArrayList <String> V_Letter = new ArrayList<String>();
    ArrayList <String> W_Letter = new ArrayList<String>();
    ArrayList <String> X_Letter = new ArrayList<String>();
    ArrayList <String> Y_Letter = new ArrayList<String>();
    ArrayList <String> Z_Letter = new ArrayList<String>();
    TextView t13, t14, t15;
    EditText e;
    Button b11;
    int counter=0, result=0, seconds_passed=0, turn=0;
    int a=1, b=1, c=1, d=1, e1=1, f=1, g=1, h=1, i=1, j=1, k=1, l=1, m=1, n=1, o=1, p=1, q=1, r1=1, s=1, t=1, u=1, v=1, w=1, x=1, y=1, z=1;
    int [] points=new int[2];
    int level=0;
    String pts1="", pts2="", c_word="";
    boolean err_flag=false, flag=false;//flag is only true if there's an error
    Winner winner;

    public SixthActivity()throws IOException
    {
        winner = new Winner();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        t13=(TextView)findViewById(R.id.textView13);
        t14=(TextView)findViewById(R.id.textView14);
        t15=(TextView)findViewById(R.id.textView15);
        e=(EditText)findViewById(R.id.editText);
        b11=(Button)findViewById(R.id.button11);
        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        level=bundle.getInt("level");
        AssetManager assetManager=getAssets();
        try
        {
            InputStream inputStream=assetManager.open("wordlist3.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            if(level==3)
            {
                while((line=br.readLine())!=null)
                {
                    String word=line.trim();
                    if (line.startsWith("W"))
                    {
                        word_list1.add(word);//for checking for binary search
                        W_Letter.add(line);//for computer to suggest words
                    }
                }
            }
            else if(level==1)
            {
                while((line=br.readLine())!=null)
                {
                    String word=line.trim();
                    word_list1.add(word);
                    if(line.startsWith("A"))
                        A_Letter.add(line);
                    else if(line.startsWith("B"))
                        B_Letter.add(line);
                    else if (line.startsWith("C"))
                        C_Letter.add(line);
                    else if (line.startsWith("D"))
                        D_Letter.add(line);
                    else if (line.startsWith("E"))
                        E_Letter.add(line);
                    else if (line.startsWith("F"))
                        F_Letter.add(line);
                    else if (line.startsWith("G"))
                        G_Letter.add(line);
                    else if (line.startsWith("H"))
                        H_Letter.add(line);
                    else if (line.startsWith("I"))
                        I_Letter.add(line);
                    else if (line.startsWith("J"))
                        J_Letter.add(line);
                    else if (line.startsWith("K"))
                        K_Letter.add(line);
                    else if (line.startsWith("L"))
                        L_Letter.add(line);
                    else if (line.startsWith("M"))
                        M_Letter.add(line);
                    else if (line.startsWith("N"))
                        N_Letter.add(line);
                    else if (line.startsWith("O"))
                        O_Letter.add(line);
                    else if (line.startsWith("P"))
                        P_Letter.add(line);
                    else if (line.startsWith("Q"))
                        Q_Letter.add(line);
                    else if (line.startsWith("R"))
                        R_Letter.add(line);
                    else if (line.startsWith("S"))
                        S_Letter.add(line);
                    else if (line.startsWith("T"))
                        T_Letter.add(line);
                    else if (line.startsWith("U"))
                        U_Letter.add(line);
                    else if (line.startsWith("V"))
                        V_Letter.add(line);
                    else if (line.startsWith("W"))
                        W_Letter.add(line);
                    else if (line.startsWith("X"))
                        X_Letter.add(line);
                    else if (line.startsWith("Y"))
                        Y_Letter.add(line);
                    else if (line.startsWith("Z"))
                        Z_Letter.add(line);

                }
                System.out.println(java.util.Collections.binarySearch(word_list1, "HOUSE"));
            }

        }

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR LOADING DICTIONARY");
        }
        if(level==1) {
            Collections.shuffle(A_Letter);

            Collections.shuffle(B_Letter);
            Collections.shuffle(C_Letter);
            Collections.shuffle(D_Letter);
            Collections.shuffle(E_Letter);
            Collections.shuffle(F_Letter);
            Collections.shuffle(G_Letter);
            Collections.shuffle(H_Letter);
            Collections.shuffle(I_Letter);
            Collections.shuffle(J_Letter);
            Collections.shuffle(K_Letter);
            Collections.shuffle(L_Letter);
            Collections.shuffle(M_Letter);
            Collections.shuffle(N_Letter);
            Collections.shuffle(O_Letter);
            Collections.shuffle(P_Letter);
            Collections.shuffle(Q_Letter);
            Collections.shuffle(R_Letter);
            Collections.shuffle(S_Letter);
            Collections.shuffle(T_Letter);
            Collections.shuffle(U_Letter);
            Collections.shuffle(V_Letter);
            Collections.shuffle(W_Letter);
            Collections.shuffle(X_Letter);
            Collections.shuffle(Y_Letter);
            Collections.shuffle(Z_Letter);
        }
        else if(level==3)
            Collections.shuffle(W_Letter);
        b11.setOnClickListener(vocl);
        firstWord();//first computer generated word

       // start();
    }//end of onCreate()

    /*Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            seconds_passed++;
            if (seconds_passed == 5)
            {
                errorMessage(4);
                System.out.println("Time's up!");
                //computerWord();
                stop();
            }
        }
    };


    public void start()
    {
        seconds_passed = 0;
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }


    public void stop()
    {
        task.cancel();

        seconds_passed=0;
    }*/

    private void dispTimerMessage(final String msg){
        SixthActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast=Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0,0);
                toast.show();
                computerWord();
                t15.setText(c_word);
                t14.setText(pts2);
                seconds_passed=0;
                //start();
            }
        });
    }
    public boolean contain(String word)
    {
        return (java.util.Collections.binarySearch(word_list1, word) >= 0);
    }

    public void processWord(String w)
    {
        String word=w.toUpperCase();
        int index,list_size, prev_length;
        String prev;
        if(level==3)
        {
            index = used_words.indexOf(word);
            if(word.charAt(0)=='W')
            {
                if(contain(word))
                {
                    if(index==-1)
                    {
                        used_words.add(word);
                        points[0]+=word.length();
                        pts1=points[0]+ " POINTS";
                        removeUserPlayedWord(word);
                        err_flag=true;

                    }
                    else//word has been played
                        errorMessage(1);
                }
                else//not a dictionary word
                    errorMessage(3);
            }
            else//doesnt start w/ W
            errorMessage(5);
        }
        else if(level==1)
        {
            if(contain(word))
            {
                list_size = used_words.size();
                index = used_words.indexOf(word);
                prev = used_words.get(list_size - 1);
                prev_length = prev.length();

                if (word.charAt(0) == prev.charAt(prev_length - 1))//if last letter of previous word is the starting letter of next word//
                {
                    if (index == -1)//new word entered
                    {
                        used_words.add(word);
                        points[0]+=word.length();
                        pts1=points[0]+ " POINTS";
                        removeUserPlayedWord(word);
                        err_flag=true;
                        //stop();

                    }

                    else//word starts w/ correct letter but has already been entered
                        errorMessage(1);
                }

                else//word starts w/ wrong letter
                    errorMessage(2);


            }//end of outermost if

            else//not a valid word
                errorMessage(3);
        }
    }

    public void errorMessage(int code)
    {
        String err="";
        switch(code) {
            case 1:
                err = "Word already played! Enter another one";
                flag = true;
                break;
            case 2:
                err = "The word must start with the last letter of the previous word";
                flag = true;
                break;
            case 3:
                err = "The word does not belong in the dictionary";
                flag = true;
                break;
            case 4:
                err = "Time's up!\nYour turn has passed";
                dispTimerMessage(err);
                break;
            case 5:
                err="The word must start with the letter W";
                flag=true;
        }
        //if(flag)
            Toast.makeText(getApplicationContext(), err,Toast.LENGTH_SHORT ).show();

    }

    private View.OnClickListener vocl= new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            String w=e.getText().toString();//get word
            processWord(w);
            if(err_flag)
            {
                t13.setText(pts1);
                //timerClass.stop(context);
            }

            result=winner.checkWinner(points[0], 50, 1);
            if(result==1) goToLastScreen();
            e.setText("");
            //e.getText().clear();
            if(result!=1 && !flag)
            {
                computerWord();
                t15.setText(c_word);
                t14.setText(pts2);
                result = winner.checkWinner(points[1], 50, 2);
                if (result == 2) goToLastScreen();
            }
            else
                flag=false;//set to previous state
        }

    };

    private void goToLastScreen() {
        String winnername="", message="";
        Intent intent=new Intent(this, FourthActivity.class);
        if(result==1)
        {
            winnername="YOU WIN";
            message="CONGRATULATIONS!!";
        }
        else
        {
            winnername="YOU LOSE";
            message="OOPS!";
        }
        char mode='s';
        Bundle b=new Bundle();
        b.putString("winner", winnername);
        b.putString("message", message);
        b.putChar("mode", mode);
        intent.putExtras(b);
        startActivity(intent);

    }

    private void updateTextView(final String s) {
        SixthActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                t15.setText(s);
                String disp=points[1]+" POINTS";
                t14.setText(disp);
            }
        });

    }
    public void firstWord()
    {
        String first_word="";
        if(level==3)
        {
            first_word=W_Letter.get(0);
        }
        else if(level==1)
        {
            Random r=new Random();
            int letter=r.nextInt(26);
            switch (letter)
            {
                case 0: first_word=A_Letter.get(0); break;
                case 1: first_word=B_Letter.get(0); break;
                case 2: first_word=C_Letter.get(0); break;
                case 3: first_word=D_Letter.get(0); break;
                case 4: first_word=E_Letter.get(0); break;
                case 5: first_word=F_Letter.get(0); break;
                case 6: first_word=G_Letter.get(0); break;
                case 7: first_word=H_Letter.get(0); break;
                case 8: first_word=I_Letter.get(0); break;
                case 9: first_word=J_Letter.get(0); break;
                case 10: first_word=K_Letter.get(0); break;
                case 11: first_word=L_Letter.get(0); break;
                case 12: first_word=M_Letter.get(0); break;
                case 13: first_word=N_Letter.get(0); break;
                case 14: first_word=O_Letter.get(0); break;
                case 15: first_word=P_Letter.get(0); break;
                case 16: first_word=Q_Letter.get(0); break;
                case 17: first_word=R_Letter.get(0); break;
                case 18: first_word=S_Letter.get(0); break;
                case 19: first_word=T_Letter.get(0); break;
                case 20: first_word=U_Letter.get(0); break;
                case 21: first_word=V_Letter.get(0); break;
                case 22: first_word=W_Letter.get(0); break;
                case 23: first_word=X_Letter.get(0); break;
                case 24: first_word=Y_Letter.get(0); break;
                case 25: first_word=Z_Letter.get(0); break;
            }//end of switch
        }

        used_words.add(first_word);
        points[1]+=first_word.length();
        updateTextView(first_word);

    }


    public void computerWord()
    {

        if(level==3)
        {
            c_word=W_Letter.get(w);
            used_words.add(c_word);
            w++;
        }
        else if(level==1)
        {    int list_size, prev_length, index;
            String prev="";
            list_size = used_words.size();
            //index = used_words.indexOf(word);
            prev = used_words.get(list_size - 1);
            prev_length = prev.length();
            char start=prev.charAt(prev_length-1);//last letter of previous word
            switch (start)
            {
                case 'A': c_word=A_Letter.get(a); a++; used_words.add(c_word); break;
                case 'B': c_word=B_Letter.get(b); b++; used_words.add(c_word); break;
                case 'C': c_word=C_Letter.get(c); c++; used_words.add(c_word); break;
                case 'D': c_word=D_Letter.get(d); d++; used_words.add(c_word); break;
                case 'E': c_word=E_Letter.get(e1); e1++; used_words.add(c_word); break;
                case 'F': c_word=F_Letter.get(f); f++; used_words.add(c_word); break;
                case 'G': c_word=G_Letter.get(g); g++; used_words.add(c_word); break;
                case 'H': c_word=H_Letter.get(h); h++; used_words.add(c_word); break;
                case 'I': c_word=I_Letter.get(i); i++; used_words.add(c_word); break;
                case 'J': c_word=J_Letter.get(j); j++; used_words.add(c_word); break;
                case 'K': c_word=K_Letter.get(k); k++; used_words.add(c_word); break;
                case 'L': c_word=L_Letter.get(l); l++; used_words.add(c_word); break;
                case 'M': c_word=M_Letter.get(m); m++; used_words.add(c_word); break;
                case 'N': c_word=N_Letter.get(n); n++; used_words.add(c_word); break;
                case 'O': c_word=O_Letter.get(o); o++; used_words.add(c_word); break;
                case 'P': c_word=P_Letter.get(p); p++; used_words.add(c_word); break;
                case 'Q': c_word=Q_Letter.get(q); q++; used_words.add(c_word); break;
                case 'R': c_word=R_Letter.get(r1); r1++; used_words.add(c_word); break;
                case 'S': c_word=S_Letter.get(s); s++; used_words.add(c_word); break;
                case 'T': c_word=T_Letter.get(t); t++; used_words.add(c_word); break;
                case 'U': c_word=U_Letter.get(u); u++; used_words.add(c_word); break;
                case 'V': c_word=V_Letter.get(v); v++; used_words.add(c_word); break;
                case 'W': c_word=W_Letter.get(w); w++; used_words.add(c_word); break;
                case 'X': c_word=X_Letter.get(x); x++; used_words.add(c_word); break;
                case 'Y': c_word=Y_Letter.get(y); y++; used_words.add(c_word); break;
                case 'Z': c_word=Z_Letter.get(z); z++; used_words.add(c_word); break;
            }
        }
        points[1]+=c_word.length();
        pts2=points[1]+ " POINTS";

    }



    public void removeUserPlayedWord(String w)
    {
        if (level==3)
        {
            W_Letter.remove(w);
        }

        else if(level==1)
        {
            char start = w.charAt(0);
            switch (start)
            {
                case 'A': A_Letter.remove(w); break;
                case 'B': B_Letter.remove(w); break;
                case 'C': C_Letter.remove(w); break;
                case 'D': D_Letter.remove(w); break;
                case 'E': E_Letter.remove(w); break;
                case 'F': F_Letter.remove(w); break;
                case 'G': G_Letter.remove(w); break;
                case 'H': H_Letter.remove(w); break;
                case 'I': I_Letter.remove(w); break;
                case 'J': J_Letter.remove(w); break;
                case 'K': K_Letter.remove(w); break;
                case 'L': L_Letter.remove(w); break;
                case 'M': M_Letter.remove(w); break;
                case 'N': N_Letter.remove(w); break;
                case 'O': O_Letter.remove(w); break;
                case 'P': P_Letter.remove(w); break;
                case 'Q': Q_Letter.remove(w); break;
                case 'R': R_Letter.remove(w); break;
                case 'S': S_Letter.remove(w); break;
                case 'T': T_Letter.remove(w); break;
                case 'U': U_Letter.remove(w); break;
                case 'V': V_Letter.remove(w); break;
                case 'W': W_Letter.remove(w); break;
                case 'X': X_Letter.remove(w); break;
                case 'Y': Y_Letter.remove(w); break;
                case 'Z': Z_Letter.remove(w); break;
            }
        }
    }
    }
