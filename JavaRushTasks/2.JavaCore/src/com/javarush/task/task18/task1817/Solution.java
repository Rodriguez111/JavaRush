package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);

        int countSpaces=0;
        int countSymbols=0;

        while (fis.available()>0){
            int bytes=fis.read();

            if (bytes==32){countSpaces++;}
            else{countSymbols++;}

        }
        fis.close();

        float result=(float)countSpaces/(countSymbols+countSpaces)*100;
        DecimalFormat decimalFormat = new DecimalFormat(".##"); //задаем шаблон округления до сотых

        System.out.println(decimalFormat.format(result));

    }
}
