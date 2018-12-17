package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        Iterator<Cat> iter = cats.iterator();//создаем итератор

            if(iter.hasNext()){ //проверяем есть ли хоть один элемент в коллекции
            cats.remove(iter.next());//удаляем его
        }

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> cats = new HashSet<>();

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (Cat c:cats
             ) {
            System.out.println(c);
            
        }
    }

    public static class Cat{

    }
}
