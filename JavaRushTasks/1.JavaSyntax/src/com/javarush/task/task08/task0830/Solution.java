package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
    String temp;
    boolean wasAnySwap=true;//был ли хоть один обмен

     for(int j=0;j<array.length-1;j++) {

         if (!wasAnySwap){break;}//если ни одного обмена за проход не было - готово
         wasAnySwap=false;//обмена не было
         for (int i = 0; i < array.length - 1; i++) {
             if (isGreaterThan(array[i], array[i + 1])) {//обмен значений
                 temp = array[i];//значение a во временную переменную
                 array[i] = array[i + 1];//значение b перемещается на место a
                 array[i + 1] = temp;//значение a перемещается на место b
                 wasAnySwap=true;//обмен был
             }
         }
     }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
