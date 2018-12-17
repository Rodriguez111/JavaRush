package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        int num=scan.nextInt();


        if (num%2==0 && lengthOfInt(num)==1 && num!=0){
            System.out.println("четное однозначное число");
        }
        else if (num%2==0 && lengthOfInt(num)==2){
            System.out.println("четное двузначное число");
        }
        else if (num%2==0 && lengthOfInt(num)==3){
            System.out.println("четное трехзначное число");
        }
        else if (num%2!=0 && lengthOfInt(num)==1){
            System.out.println("нечетное однозначное число");
        }
        else if (num%2!=0 && lengthOfInt(num)==2){
            System.out.println("нечетное двузначное число");
        }
        else if (num%2!=0 && lengthOfInt(num)==3){
            System.out.println("нечетное трехзначное число");
        }
        else{}

    }

    public static int lengthOfInt(int a){
        int length;
        if (a==0) {length=1;}
        else{
//            if(a<0){
//                a=-a;
//            }

             length=0;
            while (a>0){
               a=a/10;
                length=length+1;
            }
        }
        return length;

    }


}
