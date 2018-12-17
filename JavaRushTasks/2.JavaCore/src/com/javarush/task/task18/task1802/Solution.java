package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String file = r.readLine();

        InputStream inp = new FileInputStream(file);
        int readByte;
        int min=inp.read();


        while(inp.available()>0){
            readByte=inp.read();

            if (readByte<min){min=readByte;}

        }
        inp.close();
        r.close();

        System.out.println(min);









    }
}
