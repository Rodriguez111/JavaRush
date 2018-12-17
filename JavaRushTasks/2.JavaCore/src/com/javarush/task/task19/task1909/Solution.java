package com.javarush.task.task19.task1909;

/* 
Замена знаков
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


        while (br.ready()){
            int bytes = br.read();
            if (bytes == 46){bytes = 33;}

                bw.write(bytes);
        }
        br.close();
        bw.close();

    }
}
