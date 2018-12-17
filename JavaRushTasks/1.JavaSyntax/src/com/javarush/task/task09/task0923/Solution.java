package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        String ishodnayaStroka=scan.nextLine().replaceAll(" ","");//считываем строку в переменную и удаляем пробелы



        char[] chArray = ishodnayaStroka.toCharArray();//загоняем строку в массив символов

       for (int i=0;i<chArray.length;i++) {

          if(isVowel(chArray[i])){
              System.out.print(chArray[i]+" ");

          }
       }
        System.out.println();
        for (int i=0;i<chArray.length;i++) {

            if(!isVowel(chArray[i])){
                System.out.print(chArray[i]+" ");

            }
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}