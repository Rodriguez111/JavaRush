package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        Scanner scan=new Scanner(System.in);
        String a=scan.nextLine();
        return a;

    }

    public static int readInt() throws Exception {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        return a;

    }

    public static double readDouble() throws Exception {
        Scanner scan=new Scanner(System.in);
        double a=scan.nextDouble();
        return a;

    }

    public static boolean readBoolean() throws Exception {
        Scanner scan=new Scanner(System.in);
        boolean a=scan.nextBoolean();
        return a;

    }

    public static void main(String[] args) {

    }
}
