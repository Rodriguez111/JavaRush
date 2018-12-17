package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int summa=0;
        int s=0;
        String t;


        while (true) {
            if (scan.hasNextInt()) {//проверка - число ли
                s = scan.nextInt();
            }
            else {
                t = scan.nextLine(); //проверка строка ли
                if (t=="сумма"){break;}

                break;
            }

            summa=summa+s;

        }
        System.out.println(summa);




    }
}
