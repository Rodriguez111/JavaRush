package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        PrintStream ps = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(baos);

        System.setOut(newStream);

        testString.printSomething();
        String res = baos.toString();

        System.setOut(ps);

        FileOutputStream fos = new FileOutputStream(fileName);

        fos.write(res.getBytes());
        fos.close();

        System.out.println(res);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

