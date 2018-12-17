package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close(); //закрываем поток

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if(n<0){return "0";}
        if(n==0){return "1";}
        else {
        return String.valueOf(fctrl(n));
        }
    }



    static BigInteger fctrl(int n){//факториал через рекурсию
        if (n==1) return BigInteger.valueOf(1);
        return fctrl(n-1).multiply(BigInteger.valueOf(n));
    }

}
