package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        try {

            String string = args[0];

            int min = 37;
            for (int i = 2; i <= 36; i++) {

                try {
                    BigInteger bigInteger = new BigInteger(string, i);
                    //System.out.println(bigInteger);
                } catch (NumberFormatException e) {
                    //System.out.println("!!");
                    continue;
                }
                if (i < min) min = i;
            }

            if (min == 37) System.out.println("incorrect");
            else System.out.println(min);

        }catch (Exception e){
            /*NOP*/
        }



    }
}