package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    private int top, left, width, height;


    public void initialize(int top, int left, int width, int height){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=height;
     }


    public void initialize(int top, int left){
        this.top=top;
        this.left=left;
        this.width=1;
        this.height=1;
    }

    public void initialize(int top, int left, int width){
        this.top=top;
        this.left=left;
        this.width=width;
        this.height=width;
    }

    public void initialize(Rectangle anotherRectangle){
        this.top=anotherRectangle.top;
        this.left=anotherRectangle.left;
        this.width=anotherRectangle.width;
        this.height=anotherRectangle.height;
    }



    public static void main(String[] args) {

    }
}
