package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String fileName = br.readLine();
            br.close();


        FileInputStream in = new FileInputStream(fileName);
        int count=0;

while(in.available()>0){
    if(in.read()==44){count++;}
}
in.close();
        System.out.println(count);


    }
}
