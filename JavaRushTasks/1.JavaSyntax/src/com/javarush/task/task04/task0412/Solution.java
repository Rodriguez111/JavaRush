package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();

        if(a<0){a=a+1;}
        else if(a>0){a=a*2;}
        else {a=a;}

        System.out.println(a);

    }

}