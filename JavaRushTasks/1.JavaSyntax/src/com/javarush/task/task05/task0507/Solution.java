package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        int count=0;
        int summa=0;
        while (true){
            int num=scan.nextInt();
            if (num==-1){
                System.out.println((double)summa/count);
                break;
            }
            count=count+1;
            summa=summa+num;
        }


    }
}

