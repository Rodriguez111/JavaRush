package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        int[]arr=new int[10];

        for(int i=0;i<8;i++){
          arr[i]=scan.nextInt();
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[arr.length-1-i]);
        }

    }
}