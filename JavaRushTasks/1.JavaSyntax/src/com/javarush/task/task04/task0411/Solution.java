package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);

    }

    public static void checkSeason(int month) {
        switch (month){
            case 1:
            case 2:
            case 12:
                System.out.println("зима");
                return;
            case 3:
            case 4:
            case 5:
                System.out.println("весна");
                return;
            case 6:
            case 7:
            case 8:
                System.out.println("лето");
                return;
            case 9:
            case 10:
            case 11:
                System.out.println("осень");
                return;
            default: System.out.println("Месяц введен неверно");
                return;

        }
    }
}