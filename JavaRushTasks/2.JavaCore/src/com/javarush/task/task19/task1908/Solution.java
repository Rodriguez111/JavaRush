package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        while ((line = br.readLine())!=null){

            for(String word : line.split(" ")){
 //                  if(word.matches("\\d+")){ // альтернативный способ распознать только цифры
//                   bw.write(word+" ");
//                }
                if(word.matches("[0-9]+")){//только цифры
                     bw.write(word+" ");
                }
            }

        }

        br.close();
        bw.close();


    }
}
