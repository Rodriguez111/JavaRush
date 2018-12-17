package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int year=scan.nextInt();
        int x;

        if (year%4==0 && year%100!=0){x=366;}
        else if (year%400==0){x=366;}

        else x=365;

        System.out.println("количество дней в году: "+x);




        }





    }
