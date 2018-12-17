package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    public static ArrayList<Cat>cats=new ArrayList<Cat>();


    public Cat() {

    }

    public static void main(String[] args) {
       Cat[]cat=new Cat[10];
       for (int i=0;i<10;i++){

        Cat.cats.add(cat[i]=new Cat());
        }



        printCats();
    }

    public static void printCats() {
        for (int i=0; i<cats.size();i++){
            System.out.println(cats.get(i));
        }


    }
}
