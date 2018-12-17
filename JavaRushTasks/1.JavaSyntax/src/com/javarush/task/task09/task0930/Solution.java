package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {

        boolean wasIsGreaterThanUsed=true; //метка, показывающая была ли перестановка строк. Если нет, значит все строки переставлены.
        while(wasIsGreaterThanUsed) {
            wasIsGreaterThanUsed=false;
            for (int i = 0; i < array.length; i++) {

                if (isNumber(array[i]) && whatIsNextDigit(i,array)!=-1) {//если цифра
                    int nextDigit=whatIsNextDigit(i,array);
                    if (parseInt(array[i])< parseInt(array[nextDigit]))//
                    {
                        String temp = array[i];
                        array[i] = array[nextDigit];
                        array[nextDigit] = temp;
                        wasIsGreaterThanUsed=true;
                    }
                }

                if (whatIsNextString(i,array)!=-1) {//если НЕ цифра

                    int nextString=whatIsNextString(i,array);
                    if (isGreaterThan(array[i], array[nextString]))
                    {
                        String temp = array[i];
                        array[i] = array[nextString];
                        array[nextString] = temp;
                        wasIsGreaterThanUsed=true;
                    }
                }
            }
        }
    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }

    //Метод определяет индекс следующей цифры, с которой будем сравнивать текущую цифру
    public static int whatIsNextDigit(int index, String[] array) {

        int num = -1;
        for (int i = index+1; i < array.length; i++) {
            if (isNumber(array[i])) {
                num = i;
                break;
            }
        }
        return num;
    }
    //Метод определяет индекс следующей строки, с которой будем сравнивать текущую строку
    public static int whatIsNextString(int index, String[] array){

        int num=-1;
        for (int i=index+1; i < array.length; i++){
            if(!isNumber(array[i]))
            {num=i;
                break;}
        }
        return num;
    }
}
