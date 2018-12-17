package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        int c=scan.nextInt();
        int x;

        x=(a==b && a!=c)?a:(a==c && a!=b)?a:(b==c && b!=a)?b:

         (a<c  && a>b ||a<b && a>c)?a:(b<a  && b>c || b<c && b>a)?b:(c<a  && c>b || c<b && c>a)?c:c;

        System.out.println(x);

    }
}
