package com.example.myapplication;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
    TextView t13, t14;
    EditText e;
    Button b11;
    int counter=0;
    int [] points=new int[2];
    int turn=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        t13=(TextView)findViewById(R.id.textView13);
        t14=(TextView)findViewById(R.id.textView14);
        e=(EditText)findViewById(R.id.editText);
        b11=(Button)findViewById(R.id.button11);

        AssetManager assetManager=getAssets();
        try
        {
            InputStream inputStream=assetManager.open("wordlist3.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
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

        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR LOADING DICTIONARY");
        }


    }//end of onCreate()

    public boolean contain(String word)
    {
        return (java.util.Collections.binarySearch(word_list1, word) >= 0);
    }

    public void processWord(String w)
    {
        String word=w.toUpperCase();
        int index,list_size, prev_length;
        String prev;
        if(contain(word))
        {
            //System.out.println(counter);
            list_size = used_words.size();
            index = used_words.indexOf(word);
            prev = used_words.get(list_size - 1);
            System.out.println(prev);
            prev_length = prev.length();

            if (word.charAt(0) == prev.charAt(prev_length - 1))//if last letter of previous word is the starting letter of next word//
            {
                if (index == -1)//new word entered
                {
                    used_words.add(word);

                    if(turn==1)//word played by player
                    {
                        //disp=s1+" gets "+String.valueOf(s.length())+ " points";
                        //noError(disp);
                        points[0]+=word.length();
                    }

                    else//word played by CPU
                    {
                        //disp=s2+" gets "+String.valueOf(s.length())+ " points";
                        //noError(disp);
                        points[1]+=word.length();
                    }
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

    public void errorMessage(int code)
    {
        String err="";
        boolean flag=false;
        switch(code) {
            case 1:
                err = "Word already played! Enter another one";
                counter--;
                flag = true;
                break;
            case 2:
                err = "The word must start with the last letter of the previous word";
                counter--;
                flag = true;
                break;
            case 3:
                err = "The word does not belong in the dictionary";
                counter--;
                flag = true;
                break;
            case 4:
                err = "Time's up!";
                counter--;
                flag = true;
                break;
            //default: err="You get "+ pt+" points";
        }
        if(flag)
            Toast.makeText(getApplicationContext(), err,Toast.LENGTH_SHORT ).show();

    }


}
