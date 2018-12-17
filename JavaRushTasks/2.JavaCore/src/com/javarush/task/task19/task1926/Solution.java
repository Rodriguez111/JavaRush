package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String str;
        while (fileReader.ready()){
            str=fileReader.readLine();
            char[] charArr = str.toCharArray();
            for (int i=charArr.length-1;i>=0;i--){
                System.out.print(charArr[i]);
            }
            System.out.println();
        }

        fileReader.close();


    }
}
