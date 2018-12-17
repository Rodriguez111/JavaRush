package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1=br.readLine();
        String fileName2=br.readLine();
        String fileName3=br.readLine();
        br.close();

        FileInputStream input = new FileInputStream(fileName1);
        FileOutputStream output1 = new FileOutputStream(fileName2);
        FileOutputStream output2 = new FileOutputStream(fileName3);

        int middle;
        if(input.available()%2>0){middle=input.available()/2+1;}
        else {middle=input.available()/2;}
        int count=0;

        while (input.available()>0){
            count++;
            int bytes = input.read();

            if(count<=middle){output1.write(bytes);}
            else{output2.write(bytes);}
        }
        input.close();
        output1.close();
        output2.close();

    }
}
