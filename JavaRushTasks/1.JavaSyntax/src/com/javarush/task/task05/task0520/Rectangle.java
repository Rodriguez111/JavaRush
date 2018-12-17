package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int  top, left, width, height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.width = 2;
        this.height = 2;
    }

    public Rectangle(Rectangle anotherRect) {
        this.top = anotherRect.top;
        this.left = anotherRect.left;
        this.width = anotherRect.width;
        this.height = anotherRect.height;
    }




    public static void main(String[] args) {

    }
}
