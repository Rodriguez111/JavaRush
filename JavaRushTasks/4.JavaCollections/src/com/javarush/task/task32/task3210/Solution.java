package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");

        int position = Integer.parseInt(args[1]);
        int lengthOfText = args[2].length();


        byte[] bytes = new byte[lengthOfText];

        raf.seek(position);
        raf.read(bytes, 0, lengthOfText); //считываем с позиции (position) столько символов, сколько в переменной lengthOfText

    String string = new String(bytes);

        raf.seek(raf.length()); //перемещаемся в конец файла

    if(string.equals(args[2])){
        raf.write("true".getBytes()); //записываем в конец файла true
    }
    else raf.write("false".getBytes()); //записываем в конец файла false


    }
}
