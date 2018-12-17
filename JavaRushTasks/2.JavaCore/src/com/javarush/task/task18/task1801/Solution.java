package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String file = r.readLine();

        InputStream inp = new FileInputStream(file);
        int readByte;
        int max=0;

        while(inp.available()>0){
            readByte=inp.read();

            if (readByte>max){max=readByte;}

        }
        inp.close();
        r.close();

        System.out.println(max);



    }
}
