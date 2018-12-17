package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;



    public static String getAllNumbersBetween(int a, int b) {

        if(a < b){
            String result = Integer.toString(a);

            while (a<b){
             a++;
                result = result+" "+a;
            }
            return result;
        }

        else if(a > b){
            String result = Integer.toString(a);

            while (a>b){
                a--;
                result = result+" "+a;
            }
            return result;
        }
        return  Integer.toString(a);

    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;

        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}