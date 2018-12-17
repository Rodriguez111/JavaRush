package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
   private  List<Horse> horses = new ArrayList<>();

    public  List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome (List horses){
        this.horses = horses;
    }

    static Hippodrome game;


    public static void main(String[] args) {

        game = new Hippodrome(new ArrayList())  ;

        Horse horse1 = new Horse("Black", 3, 0);
        Horse horse2 = new Horse("White", 3, 0);
        Horse horse3 = new Horse("Brown", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run(); //запускаем поток (игру)

        game.printWinner(); // выводим на экран имя победителя


    }

    void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    void move(){
        //вызываем метод move() у каждой лошади из списка.
        for (int i = 0; i < getHorses().size();i++){
            getHorses().get(i).move();
        }

    }
    void print(){
        //вызываем метод print() у каждой лошади из списка.
        for (int i = 0; i < getHorses().size();i++){
            getHorses().get(i).print();
        }
//отделячем каждый "кадр" (т.е. каждую итераци.в методе move()) десятью пустыми строками
        for (int i = 0; i < 10;i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        //определяем лошадь-победителя,у которой максимальное значение distance
double max = 0;
        Horse liderHorse = null;
        for(int i = 0; i < getHorses().size();i++){
            if (getHorses().get(i).getDistance()>max){
                max=getHorses().get(i).getDistance();
                liderHorse = getHorses().get(i);
            }
        }
return liderHorse;
    }

    public void printWinner(){
        //выводим на печать имя лошади-победителя
        String name = getWinner().getName();
        System.out.println("Winner is "+name+"!");


    }


}
