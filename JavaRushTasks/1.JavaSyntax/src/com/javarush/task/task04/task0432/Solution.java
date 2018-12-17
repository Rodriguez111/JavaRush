package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        String s=scan.next();
        int n=scan.nextInt();



        while (n>0)
        {
            System.out.println(s);
            n--;
        }

    }
}
