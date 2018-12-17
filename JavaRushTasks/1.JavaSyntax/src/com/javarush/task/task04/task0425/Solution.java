package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
       Scanner scan=new Scanner(System.in);

       int x=scan.nextInt();
       int y=scan.nextInt();

        int xy=(x>0)?(y>0)?1:4:(y>0)?2:3;

        System.out.println(xy);



    }
}
