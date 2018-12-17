package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();

        int count=0;
        count=(a>0)?count=count+1:count;
        count=(b>0)?count=count+1:count;
        count=(c>0)?count=count+1:count;

        System.out.println(count);

    }
}
