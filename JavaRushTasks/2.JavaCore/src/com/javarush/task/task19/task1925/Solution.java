package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        int count=0;
        String comma="";

        while (fileReader.ready()){

            String[] str = fileReader.readLine().split(" ");

            for (int i=0;i<str.length;i++){
                if(str[i].length()>6){
                    if(count>0){comma=",";}//обеспечиваем наличие запятой ыезде кроме последнего слова
                    fileWriter.write(comma+str[i]);
                    count++;
                }

            }

        }

        fileReader.close();
        fileWriter.close();

    }
}
