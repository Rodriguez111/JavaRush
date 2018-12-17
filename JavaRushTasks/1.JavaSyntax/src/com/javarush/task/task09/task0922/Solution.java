package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String d=scan.nextLine();

        SimpleDateFormat d1 = new SimpleDateFormat("MM/dd/yyyy");
        Date date = d1.parse(d);
        SimpleDateFormat d2 = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
        String newDate=d2.format(date);

        System.out.println(newDate.toUpperCase());

    }
}
