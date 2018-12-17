package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName;

        while (true){
            fileName=br.readLine();
            FileInputStream in = new FileInputStream(fileName);
            if (in.available()<1000){
                in.close();
                throw new DownloadException();
                }
        }


    }

    public static class DownloadException extends Exception {

    }
}
