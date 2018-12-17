package com.javarush.task.task08.task0823;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        s = s.replaceAll("\\s+", " "); //заменяем двойные и более пробелы на один

        if (s.indexOf(" ") == 0) {//если впереди есть пробел - убираем его
            s = s.substring(1);
        }

        String[] splitted = s.split(" ");

        String wholeWord = "";
        for (int i = 0; i < splitted.length; i++) {
            String f = splitted[i];
            String firstLetter = splitted[i].substring(0, 1).toUpperCase();
            String otherLetters = splitted[i].substring(1);
            if (i < splitted.length - 1) {
                wholeWord += firstLetter + otherLetters + " ";
            } else {
                wholeWord += firstLetter + otherLetters;
            }
        }
        System.out.println(wholeWord);

    }

}

