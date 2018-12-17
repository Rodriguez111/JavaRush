package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstFile="";
        String secondFile="";
        try {
            firstFile = br.readLine();
            secondFile = br.readLine();
            br.close();
            } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fr = new FileReader(firstFile);
            FileWriter fw = new FileWriter(secondFile);
            int count =0;
            while (fr.ready()){
                count++;
                int data =fr.read();
                if(count%2==0){
                    fw.write(data);
                }
            }
            fr.close();
            fw.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
