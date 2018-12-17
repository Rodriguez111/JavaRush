package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = br.readLine();
        String secondFileName = br.readLine();
        br.close();

        br = new BufferedReader(new FileReader(firstFileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter(secondFileName));

        String line;
        while ((line=br.readLine())!=null){

            line= line.replaceAll("[^A-Za-z ]+","");
            bw.write(line);

        }
        br.close();
        bw.close();
    }
}
