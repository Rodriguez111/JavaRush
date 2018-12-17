package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");

      int position = Integer.parseInt(args[1]);

        if(randomAccessFile.length() >= position) {
            randomAccessFile.seek(position);

        }
        else{ randomAccessFile.seek(randomAccessFile.length()); }


        byte[] text = args[2].getBytes();



        randomAccessFile.write(text);



    }
}
