package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;

        while (true)
        {

            String s = scan.readLine();
            int s1 = Integer.parseInt(s);
            if (s1==-1)
            { sum=sum+s1;break;}
            sum=sum+s1;
        }

        System.out.println(sum);

    }
}
