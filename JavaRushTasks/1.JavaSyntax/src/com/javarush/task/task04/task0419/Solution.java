package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();
        int d=scan.nextInt();

       int max=(max(a,b)>max(c,d))?max(a,b):max(c,d);
        System.out.println(max);

    }

    public static int max(int a,int b){
        int c=(a>b)?a:b;
        return c;
    }


}
