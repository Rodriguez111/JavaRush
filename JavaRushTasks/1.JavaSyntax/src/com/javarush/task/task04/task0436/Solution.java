package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sm = reader.readLine();
        int m = Integer.parseInt(sm);

        String sn = reader.readLine();
        int n = Integer.parseInt(sn);


            for(int j=1;j<=m;j++){


                for (int i=1;i<=n;i++){
                    System.out.print("8");

            }

                System.out.println();
        }



    }
}
