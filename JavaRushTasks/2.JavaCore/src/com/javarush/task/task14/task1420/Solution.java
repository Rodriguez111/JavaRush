package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int a = Integer.parseInt(scan.nextLine());

        if (a<=0) throw new Exception(); //2 условие
        int b = Integer.parseInt(scan.nextLine());
        if (b<=0) throw new Exception(); //2 условие

       /*
        Алгоритм Евклида

        Алгоритм Евклида позволяет найти нам наибольший общий делитель чисел.
        Как это работает:
        Пусть a = 18, b = 30.
        Цикл: a!=0 and b!=0
        Если a > b, то a = a % b, если меньше, то b = b % a,
        таким образом мы сначала находим остаток деления, а потом повторяем действия.
        У нас a < b, значит, ищем остаток деления b % a (30 % 18) = 12, присваиваем b = 12,
        повторяем цикл но теперь у нас уже a > b(b = 12), значит выполняем a % b (18 % 12) = 6?
        снова переходим к циклу, теперь снова b > a,
        значит выполняем b % a (30 % 6), остаток от деления 0,
        на этом мы прекращаем наш цикл и узнаем, что наибольший общий делитель 18 и 30 = 6.
        и выводим a + b (b = 0, a = 6).

*/

        while (a!=0 && b!=0){

            if (a>b) a=a%b;
            else b=b%a;
        }

        System.out.println(a+b);

    }
}
