package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");



        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);

        byte[] buffer = new byte[10];

        int count=0;

        String str="";
        while (fis.available()>0){
            count = fis.read(buffer); //считываем в буффер

            str =str+ new String(buffer,0,count,windows1251); //записываем из буфера в строковую переменную
        }

        System.out.println(str);

        buffer = str.getBytes(utf8);

        fos.write(buffer);

        fis.close();
        fos.close();

    }
}
