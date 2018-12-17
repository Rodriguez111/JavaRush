package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        String name=scan.nextLine();
        int age =scan.nextInt();

        if(age<18){
            System.out.println("Подрасти еще");
        }


    }
}
