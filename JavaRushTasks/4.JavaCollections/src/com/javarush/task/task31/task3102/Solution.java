package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {


        LinkedList<String> listOfFiles = new LinkedList<>();

        Queue<File> queue = new LinkedList();
        queue.add(new File(root));

        while (!queue.isEmpty()){
            for(File eachFile:  queue.poll().listFiles()){
                if(eachFile.isDirectory()){
                    queue.add(eachFile);
                }
                else{listOfFiles.add(eachFile.getPath());}
            }

        }
        return listOfFiles;

    }

    public static void main(String[] args) throws IOException {

        for(String eee : getFileTree("D:\\Java\\Files")){
            System.out.println(eee);
        }
        
    }
}
