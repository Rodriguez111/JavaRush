package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);

        String name1=scan.nextLine();
        String name2=scan.nextLine();


        if (name1.equals(name2)){
            System.out.println("Имена идентичны");
        }
        else if (lengthCompare(name1,name2)==true){
            System.out.println("Длины имен равны");
        }


    }

    public static boolean lengthCompare(String a, String b){
        boolean x=(a.length()==b.length())?true:false;
        return x;

    }




}
