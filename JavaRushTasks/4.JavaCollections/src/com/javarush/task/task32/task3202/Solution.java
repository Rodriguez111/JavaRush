package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\Java\\Files\\1.txt"));

        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

        if(is == null){return new StringWriter();}


        StringWriter stringWriter = new StringWriter();

        while (is.available()>0){
            stringWriter.write(is.read());

        }

        return stringWriter;
    }
}