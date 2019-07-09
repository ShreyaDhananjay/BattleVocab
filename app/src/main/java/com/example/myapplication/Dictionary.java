package com.example.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary  {
    public Set<String> wordsSet;
    public ArrayList<String> word_list=new ArrayList<String>();
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Dictionary() throws IOException
    {

          /*
            Path path = Paths.get("wordlist.txt");

            byte[] readBytes = Files.readAllBytes(path);

            String wordListContents = new String(readBytes, "UTF-8");
            String[] words = wordListContents.split("\n");
            wordsSet = new HashSet<>();
            Collections.addAll(wordsSet, words);*/
        }


    public void readWordList(AssetManager assetManager)throws IOException
    {
        /*
        try
        {
            String filename="C://Users//Shreya//Documents//BattleVocab-master//app//src//main//java//com//example//myapplication//wordlist.txt";
           // File directory=new File(String.valueOf(context.getFilesDir()));
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String word;
            while ((word = br.readLine()) != null) {
                word_list.add(word);
            }
            br.close();
        }

        catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("error");
        }*/

        try
        {
            String filename="C://Users//Shreya//Documents//BattleVocab-master//app//src//main//java//com//example//myapplication//wordlist.txt";
            InputStream inputStream=assetManager.open(filename);
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line=br.readLine())!=null)
            {
                String word=line.trim();
                word_list.add(word);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("ERROR LOADING DICTIONARY");
        }
    }

    public boolean contain(String word)
    {
        return (java.util.Collections.binarySearch(word_list, word) > 0);
        //return wordsSet.contains(word);
    }
}
