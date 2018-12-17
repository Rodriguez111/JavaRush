package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
       Scanner scan=new Scanner(System.in);

       int a=scan.nextInt();

        if(a==0){
            System.out.println("ноль");
        }

        if(a!=0) {

            String s = (a > 0) ? (a % 2 == 0) ? "положительное четное число" : "положительное нечетное число" : (a % 2 == 0) ? "отрицательное четное число" : "отрицательное нечетное число";

            System.out.println(s);
        }


    }
}
