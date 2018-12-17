package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        if(a>b){
            System.out.println(b);
        }
        else if (a<b) {
            System.out.println(a);
        }
        else System.out.println(a);

    }
}