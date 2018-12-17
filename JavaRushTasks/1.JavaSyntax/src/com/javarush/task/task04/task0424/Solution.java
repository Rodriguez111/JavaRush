package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

      int a=scan.nextInt();
      int b=scan.nextInt();
      int c=scan.nextInt();


        if((a!=b)&&(a!=c)){

    }
        if((a==b)&&(a==c)){

        }

        if((a==b)&&(a!=c)){
            System.out.println(3);
        }
        if((a==c)&&(a!=b)){
            System.out.println(2);
        }
        if((b==c)&&(a!=b)){
            System.out.println(1);
        }




    }






}
