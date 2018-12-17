package com.javarush.task.task04.task0443;


/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();
        String syy = reader.readLine();
        int nyy = Integer.parseInt(syy);

        String smm = reader.readLine();
        int nmm = Integer.parseInt(smm);

        String sdd = reader.readLine();
        int ndd = Integer.parseInt(sdd);

        System.out.println("Меня зовут "+name+".");
        System.out.println("Я родился "+ndd+"."+nmm+"."+nyy);

    }
}
