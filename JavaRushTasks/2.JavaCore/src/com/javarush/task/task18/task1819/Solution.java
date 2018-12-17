package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String file1 = br.readLine();
        String file2 = br.readLine();

        br.close();

        FileInputStream fis = new FileInputStream(file1);

        List<Integer> bytes = new ArrayList<>();
        while (fis.available()>0){
            bytes.add(fis.read());
        }
        fis.close();
        fis.close();

        FileOutputStream fos = new FileOutputStream(file1);
        fis = new FileInputStream(file2);

        while (fis.available()>0){
            fos.write(fis.read());
        }
        fis.close();
        fos.close();
        fos = new FileOutputStream(file1, true);
        for (int i = 0;i<bytes.size();i++){

            fos.write(bytes.get(i));

        }
        fos.close();




    }
}
