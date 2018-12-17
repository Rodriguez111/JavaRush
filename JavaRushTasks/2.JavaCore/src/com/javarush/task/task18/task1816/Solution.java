package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream(args[0]);

        int count=0;
        while (is.available()>0){
            int bytes=is.read();
            if ((bytes>=65 && bytes<=90)||(bytes>=97 && bytes<=122)){
                count++;
            }

        }

        is.close();
        System.out.println(count);


    }
}
