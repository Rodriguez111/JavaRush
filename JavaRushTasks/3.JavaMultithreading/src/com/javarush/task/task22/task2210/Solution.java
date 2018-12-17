package com.javarush.task.task22.task2210;

import jdk.nashorn.internal.parser.Token;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        for (int i=0; i<getTokens("level22.lesson13.task01", ".").length;i++){

            System.out.println(getTokens("level22.lesson13.task01", ".")[i]);
        }



    }
    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer t = new StringTokenizer(query, delimiter);
        ArrayList<String> str = new ArrayList<>();

        while(t.hasMoreTokens()){
            str.add(t.nextToken());
        }

        String[] words = new String[0];
        words = str.toArray(words);


        return words;
    }
}
