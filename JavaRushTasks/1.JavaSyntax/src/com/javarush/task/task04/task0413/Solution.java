package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        switch (a) {
            case 1:
                System.out.println("понедельник");
                return;
            case 2:
                System.out.println("вторник");
                return;
            case 3:
                System.out.println("среда");
                return;
            case 4:
                System.out.println("четверг");
                return;
            case 5:
                System.out.println("пятница");
                return;
            case 6:
                System.out.println("суббота");
                return;
            case 7:
                System.out.println("воскресенье");
                return;

            default:
                System.out.println("такого дня недели не существует");
                return;


        }
    }
}