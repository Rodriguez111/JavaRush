package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

        while (br.ready()){

            String[] str = br.readLine().split(" ");
            for(int i=0;i<str.length;i++){
                char[] charArray = str[i].toCharArray();

                for(int j=0;j<charArray.length;j++){
                   if(Character.isDigit(charArray[j])){
                       bw.write(str[i]+" ");
                       break;
                   }

                }
            }
        }

        br.close();
        bw.close();

    }
}
