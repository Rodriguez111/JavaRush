package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();

        if (a==b &&a==c){
            System.out.println(a+" "+b+" "+c);
        }

        else if (a==b){
            System.out.println(a+" "+b);
        }

        else if (a==c){
            System.out.println(a+" "+c);
        }
        else if (b==c){
            System.out.println(b+" "+c);
        }

    }
}