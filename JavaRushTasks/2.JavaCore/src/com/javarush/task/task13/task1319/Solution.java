package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
        String lineSeparator = System.getProperty("line.separator"); //инициализируем переводчик строки
        while(true){
            String line = reader.readLine();
            br.write(line+lineSeparator);
            if (line.equals("exit"))break;
        }
        br.close(); //закрываем поток записи в файл
    }
}
