package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        FileOutputStream fos = new FileOutputStream(args[2]);

switch (args[0]){
    case("-e"):{
        encrypt(fis, fos);
        fis.close();
        fos.close();
    }
break;
    case("-d"):{
        decrypt(fis, fos);
        fis.close();
        fos.close();

    }
    break;
}

    }

    private static void encrypt(FileInputStream fis, FileOutputStream fos) throws IOException {
        while (fis.available()>0){
            fos.write(fis.read()+1);//Добавляем 1 байт(шифруем)
        }
    }

    private static void decrypt(FileInputStream fis, FileOutputStream fos) throws IOException {
        while (fis.available()>0){
            fos.write(fis.read()-1);//Отнимаем 1 байт(дешифруем)
        }
    }


}
