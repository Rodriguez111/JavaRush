package com.javarush.task.task05.task0503;


/* 
Геттеры и сеттеры для класса Dog
*/

public class Dog {
    private String name;
    private int age;


    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setName(String newName){
        name=newName;
    }


    public static void main(String[] args) {

    }
}
