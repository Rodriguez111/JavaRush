package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private  double distance;


    public Horse (String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }

    public String getName(){

        return this.name;
    }

    public double getSpeed(){
        return this.speed;
    }

    public double getDistance(){

        return this.distance;
    }

    public void move(){
/*
* Имитируем движениелошади -
* к текущему пройденному расстоянию прибавляем скорость,
* умноженную на случайный коэффициент
* */
        distance += speed*Math.random();

    }
    public void print(){
/*
Выводим на печать текущее расстояние, пройденное лошадью, выраженное в точках
* Количество точек равно текущему значению distance
* */
        String point = "";
        for(int i = 1; i<=distance; i++){
           point +="." ;
        }

        System.out.println(point+name);

    }


}
