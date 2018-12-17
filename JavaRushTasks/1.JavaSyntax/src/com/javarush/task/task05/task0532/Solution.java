package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());;

        int maximum=0;
        int num1;

       for (int i=1; i<=num;i++){

           num1 = Integer.parseInt(reader.readLine());
           if (i==1){maximum=num1;}
           else {

               if (maximum <= num1) {
                   maximum = num1;
               } else {
                   continue;
               }
           }


       }
        System.out.println(maximum);
    }
}
