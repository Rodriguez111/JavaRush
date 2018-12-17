package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);


    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();
        Cat[] cat=new Cat[4];
        for(int i=0;i<cat.length;i++) {

            result.add(cat[i] = new Cat());

        }
        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        Dog[] dog=new Dog[3];
        for(int i=0;i<dog.length;i++)

            result.add(dog[i]=new Dog());

        return result;

    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> result = new HashSet<>();
        Iterator<Cat> iterCats = cats.iterator();
        while(iterCats.hasNext()){result.add(iterCats.next()); }//добавляем кошек

        Iterator<Dog> iterDogs = dogs.iterator();
        while(iterDogs.hasNext()){result.add(iterDogs.next()); }//добавляем собак

        return result;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {

            pets.removeAll(cats);

    }

    public static void printPets(Set<Object> pets) {
        Iterator it=pets.iterator();
        while (it.hasNext()) {

            System.out.println(it.next());

        }
    }

    public static class Cat{}
    public static class Dog{}

}
