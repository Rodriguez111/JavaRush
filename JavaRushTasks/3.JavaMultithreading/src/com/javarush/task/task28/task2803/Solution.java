package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        int randomInt = ThreadLocalRandom.current().nextInt(from, to);

        return randomInt;
    }

    public static double getRandomDouble() {

        double randomDouble = ThreadLocalRandom.current().nextDouble();
        return randomDouble;
    }

    public static long getRandomLongBetween0AndN(long n) {

      long randomLong = ThreadLocalRandom.current().nextLong(0, n);
        return randomLong;
    }

    public static void main(String[] args) {


       // System.out.println(Solution.getRandomDouble());


    }
}
