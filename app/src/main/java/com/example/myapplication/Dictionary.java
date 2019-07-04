package com.example.myapplication;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dictionary
{
    public Set<String> wordsSet;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Dictionary() throws IOException
    {
        Path path = Paths.get("wordlist.txt");

        byte[] readBytes = Files.readAllBytes(path);

        String wordListContents = new String(readBytes, StandardCharsets.UTF_8);
        String[] words = wordListContents.split("\n");
        wordsSet = new HashSet<>();
        Collections.addAll(wordsSet, words);
    }

    public boolean contains(String word)
    {
        return wordsSet.contains(word);
    }
}
