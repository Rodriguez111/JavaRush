package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        Scanner scan = new Scanner(System.in);
        List <Integer> m= new ArrayList<Integer>() ;

        int i=0;
        int k;
        while (true) {
        i++;

            try {
                m.add(scan.nextInt());
            } catch (InputMismatchException e) {
                break;

                }
            }

        for (int j=0;j<i-1;j++){
            System.out.println(m.get(j));

        }






    }
}
