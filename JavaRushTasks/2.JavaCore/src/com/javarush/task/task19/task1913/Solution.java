package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(baos);
        System.setOut(newPrintStream);

        testString.printSomething();

        String intercept = baos.toString() ;

        System.setOut(printStream);

        char[] c = intercept.toCharArray();

        for (int i=0;i<c.length;i++){
//Определяем, является ли символ цифрой
            if(Character.isDigit(c[i])){System.out.print(c[i]);}

        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
