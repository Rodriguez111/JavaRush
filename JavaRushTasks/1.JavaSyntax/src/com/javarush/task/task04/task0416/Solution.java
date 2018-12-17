package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        double t=scan.nextDouble();

        int minute=(int)t;//переводим в целые полные минуты

        int minute2=(minute/5);// делим на 5, так как в одном цикле работы светофора 3+1+1=5 минут.
        // int отбрасывает остаток, получаем количество полных циклов, прошедших с начала часа.
        int minute3=minute-(minute2*5);//умножаем кол-вл полных циклов на кол-во минут в цикле(5) и вычитаем
        // полученное значение из количества минут с начала часа. Получим какая по счету минута в цикле.


        if ((minute3>=0) && (minute3<3)){System.out.println("зелёный");}
        else if (minute3==3){System.out.println("жёлтый");}
        else if (minute3==4){System.out.println("красный");}

    }
}