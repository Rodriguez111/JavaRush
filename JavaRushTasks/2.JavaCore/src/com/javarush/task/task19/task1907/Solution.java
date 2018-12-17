package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);

        String line;
        int count = 0;
        while ((line = br.readLine())!=null){
            String word;
            while(line.indexOf(" ")!=-1){
                word=line.substring(0,line.indexOf(" "));
                word=word.replaceAll("[^A-Za-z]","");
               // System.out.println(word);
                line=line.substring(line.indexOf(" ")+1);
                if(word.equals("world")){count++;};
            }
           if(line.replaceAll("[^A-Za-z]","").equals("world")){count++;};

        }
        br.close();
        System.out.println(count);

    }
}
