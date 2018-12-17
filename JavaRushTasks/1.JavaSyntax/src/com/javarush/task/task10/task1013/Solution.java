package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {

        private String name;
        private int age;
        private boolean sex;
        private String hair;
        private int height;
        private int weight;

        public Human(String name){
            name=this.name;
        }

        public Human(int age){
            age=this.age;
        }

        public Human(boolean sex){
            sex=this.sex;
        }

        public Human(String name, String hair){
            name=this.name;
            hair=this.hair;
        }
        public Human(String name, boolean sex){
            name=this.name;
            sex=this.sex;
        }

        public Human(boolean sex, int height){
            sex=this.sex;
            height=this.height;
        }

        public Human(String name, int age){
            name=this.name;
            age=this.age;
        }

        public Human(String name, int age, boolean sex){
            name=this.name;
            age=this.age;
            sex=this.sex;
        }

        public Human(String name, int age, boolean sex, String hair){
            name=this.name;
            age=this.age;
            sex=this.sex;
            hair=this.hair;
        }

        public Human(String name, int age, boolean sex, String hair, int height){
            name=this.name;
            age=this.age;
            sex=this.sex;
            hair=this.hair;
            height=this.height;
        }

    }
}
