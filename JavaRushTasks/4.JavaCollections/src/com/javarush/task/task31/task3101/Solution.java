package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {


        File folder = new File(args[0]);



        ArrayList<File> listOfFiles = new ArrayList<>();

        listFiles(folder, listOfFiles);

        Collections.sort(listOfFiles, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });



        File sourceFile =  new File(args[1]);
        String newFilePath = sourceFile.getParent()+"/allFilesContent.txt";
        File renamedFile = new  File(newFilePath);


    FileUtils.renameFile(sourceFile,renamedFile);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(renamedFile, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for(File eachFile : listOfFiles){
            try(FileInputStream fis = new FileInputStream(eachFile);
                ) {


                while (fis.available()>0){
                    fos.write(fis.read());

                }
                String lineSeparator = System.getProperty("line.separator"); //инициализируем переводчик строки
                fos.write(lineSeparator.getBytes());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void listFiles(File folder, ArrayList<File> list){



        for(File eachFile : folder.listFiles()){
            if(eachFile.isDirectory()){listFiles(eachFile, list);}

            if(eachFile.length()<=50 && !eachFile.isDirectory()){list.add(eachFile);}

        }

    }

}
