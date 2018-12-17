package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream ps = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(baos);

        System.setOut(stream);

        testString.printSomething();

        String result = baos.toString();

        System.setOut(ps);



        System.out.println(calculate(result));


    }

    public static String calculate(String str){
     int firstElement=Integer.parseInt(str.substring(0,str.indexOf(" "))); //извлекаем первый элемент
     int secondElement=Integer.parseInt(str.substring(str.indexOf(" ")+3, str.indexOf("=")-1 ));
     String operator = str.substring(str.indexOf(" ")+1,str.indexOf(" ")+2); //извлекаем оператор
        int result=0;
     switch (operator){
         case ("+"):result=firstElement+secondElement;
         break;
         case ("-"):result=firstElement-secondElement;
             break;
         case ("*"):result=firstElement*secondElement;
             break;
     }

     String res = str+Integer.toString(result);


     return res;

    }


    public static class TestString {
        public void printSomething() {
            System.out.print("3 + 6 = ");
        }
    }
}

