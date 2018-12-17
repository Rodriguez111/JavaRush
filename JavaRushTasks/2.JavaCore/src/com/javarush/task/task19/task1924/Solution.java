package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0 , "ноль");
        map.put(1 , "один");
        map.put(2 , "два");
        map.put(3 , "три");
        map.put(4 , "четыре");
        map.put(5 , "пять");
        map.put(6 , "шесть");
        map.put(7 , "семь");
        map.put(8 , "восемь");
        map.put(9 , "девять");
        map.put(10 , "десять");
        map.put(11 , "одиннадцать");
        map.put(12 , "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = fileNameReader.readLine();
        fileNameReader.close();


        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String str;
        while (fileReader.ready()){
            str=fileReader.readLine();
            String[] stringArray = str.split(" ");
            for(int i=0;i<stringArray.length;i++){
                if(stringArray[i].matches("[0-9]+")){//проверяем является ли слово числом
                    int number = Integer.parseInt(stringArray[i]); //если да, то парсим в int
                    for(Map.Entry<Integer, String> pair:map.entrySet()){
                        if(number==pair.getKey()){ //проверяем, есть ли число в мапе
                            stringArray[i]=pair.getValue(); //и если есть, то извлекаем для него значение и заменяем им элемент stringArray
                        }
                    }

                }

            }

            for(int i=0;i<stringArray.length;i++) {
                System.out.print(stringArray[i]+" ");//выводим строку в консоль
            }
            System.out.println();//перевод строки
            }

        fileReader.close();

        }

    }

