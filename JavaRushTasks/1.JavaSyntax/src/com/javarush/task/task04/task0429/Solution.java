package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();

        int countPlus=0;
        int countMinus=0;

        if(a>0){countPlus=countPlus+1;}
        else if(a<0){countMinus=countMinus+1;}
        else {}

        if(b>0){countPlus=countPlus+1;}
        else if(b<0){countMinus=countMinus+1;}
        else {}

        if(c>0){countPlus=countPlus+1;}
        else if(c<0){countMinus=countMinus+1;}
        else {}


        System.out.println("количество отрицательных чисел: "+countMinus);
        System.out.println("количество положительных чисел: "+countPlus);
    }
}
