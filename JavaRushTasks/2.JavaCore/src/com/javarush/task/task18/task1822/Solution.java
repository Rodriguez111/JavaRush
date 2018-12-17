package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        br.close();

        FileInputStream fis = new FileInputStream(file1);

        BufferedReader readFile = new BufferedReader(new InputStreamReader(fis));

String line;
        while ((line=readFile.readLine())!=null){

            if(line.substring(0,line.indexOf(" ")).equals(args[0])){
                System.out.println(line);
            }
        }
        readFile.close();


    }
}
