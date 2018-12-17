package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Своя реализация
*/
public class Solution {


    public static byte[] readBytes(String fileName) throws IOException { //читаем файл в массив байтов
        byte[]  allBytes =  Files.readAllBytes(Paths.get(fileName));
        return allBytes;
    }

    public static List<String> readLines(String fileName) throws IOException { //читаем файл в список строк

        List<String> allLines = Files.readAllLines(Paths.get(fileName));
        return allLines;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException { //записываем массив байтов в файл

        Files.write(Paths.get(fileName), bytes);

    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {

        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName), REPLACE_EXISTING );


    }



}
