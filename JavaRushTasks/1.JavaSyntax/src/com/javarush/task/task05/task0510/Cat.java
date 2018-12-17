package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    private String name;
    private int age;
    private int weight;
    private String color;
    private String address;


    public void initialize(String name){//7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
        this.name=name;
        this.age=1;
        this.weight=1;
        this.color="black";
    }

    public void initialize(String name, int weight, int age){//8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.color="black";
    }

    public void initialize(String name, int age){//9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
        this.name=name;
        this.age=age;
        this.weight=1;
        this.color="black";
    }

    public void initialize(int weight, String color){//10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
        this.age=1;
        this.weight=weight;
        this.color=color;
    }

    public void initialize(int weight, String color, String address){//11. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
        this.age=1;
        this.weight=weight;
        this.color=color;
        this.address=address;
    }




    public static void main(String[] args) {

    }
}
