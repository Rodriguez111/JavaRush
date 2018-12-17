package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;



    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());


        printDigits(a);


        System.out.println("Even: "+even);
        System.out.println("Odd: "+odd);


    }


    public static void printDigits(int a) {
        if (a / 10 > 0) {
            printDigits(a/10);
        }

        if (a % 10%2==0){even=even+1;}
        else{odd=odd+1;}


    }



}
