package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] lst=new ArrayList[4];//Создаем массив списков размером в 2 списка
        ArrayList<String> a = new ArrayList();//Создаем список

for (int j = 0; j < lst.length; j++) {

    for (int i = 0; i < 3; i++) {
        a.add("String" + i);//наполняем каждый из 5ти списков строками (3 строки)
    }
    lst[j] = a; //добавляем список в массив списков
    a = new ArrayList();
}

         return lst;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}