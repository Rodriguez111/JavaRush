package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String pathString = bufferedReader.readLine();
        Path path = Paths.get(pathString) ;

        bufferedReader.close();
        if(!Files.isDirectory(path)){
            System.out.println(path+ " - не папка");
            return;
        }

        MyFileVisitor myFileVisitor = new MyFileVisitor();

        Files.walkFileTree(path, myFileVisitor);

        System.out.println("Всего папок - " + myFileVisitor.getCountOfDirs());
        System.out.println("Всего файлов - " + myFileVisitor.getCountOfFiles());
        System.out.println("Общий размер - " + myFileVisitor.getTotalSize());



    }
}
