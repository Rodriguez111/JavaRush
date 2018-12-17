package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = br.readLine();
        String file2Name = br.readLine();
        br.close();

        FileInputStream in = new FileInputStream(file1Name);
        FileOutputStream out = new FileOutputStream(file2Name);
        int[] bytes = new int[in.available()];

        int count=0;
        while (in.available()>0){
            bytes[count] =in.read();
            count++;
        }
        in.close();

        for(int i=bytes.length-1;i>=0;i--){

            out.write(bytes[i]);
        }
        out.close();

    }
}
