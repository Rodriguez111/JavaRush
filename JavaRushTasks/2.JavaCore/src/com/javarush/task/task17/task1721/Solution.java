package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
// считываем имена файлов 0
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileAllLines="";
        String fileForRemoveLines="";
        try {
            fileAllLines = reader.readLine();
            fileForRemoveLines= reader.readLine();
            reader.close();

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

// считываем имена файлов 1

// считываем содержимое файлов 0
        File file1 = new File(fileAllLines);
        File file2 = new File(fileForRemoveLines);

        try {
            FileReader fr1 = new FileReader(file1); //создаем объект FileReader для объекта File

            BufferedReader readerFile1 = new BufferedReader(fr1); //создаем BufferedReader с существующего FileReader для построчного считывания

            String line1 = readerFile1.readLine(); // считаем сначала первую строку

            while (line1 != null) {

                allLines.add(line1); //записываем в массив
                line1 = readerFile1.readLine();// считываем остальные строки в цикле

            }


            FileReader fr2 = new FileReader(file2);
            BufferedReader readerFile2 = new BufferedReader(fr2);
            String line2 = readerFile2.readLine();
            while (line2 != null) {

                forRemoveLines.add(line2); //записываем в массив
                line2 = readerFile2.readLine();// считываем остальные строки в цикле

            }
            readerFile1.close();
            readerFile2.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при чтении файла");
        }


        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public synchronized void joinData () throws CorruptedDataException {
        boolean   forRemoveLinesContainsAllLines=true;
        if (forRemoveLines.size()<=allLines.size()) { //если размер искомого списка не превышает список, в котором ищем
            for (int i = 0; i < forRemoveLines.size(); i++) {
                if(!allLines.contains(forRemoveLines.get(i))){
                    forRemoveLinesContainsAllLines=false;
                }
            }
        }
        else {forRemoveLinesContainsAllLines=false;}//если размер превышает


        if (forRemoveLinesContainsAllLines){
            for (int i = 0; i < forRemoveLines.size(); i++) {
                allLines.remove(forRemoveLines.get(i));

            }
        }
        else{allLines.clear(); throw new CorruptedDataException();}

    }
}
