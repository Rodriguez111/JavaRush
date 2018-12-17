package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename;

        ArrayList<FileInputStream> fis = new ArrayList<>();// список для создаваемых потоков

        while (true){
            filename=br.readLine();
            try {

                fis.add(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                System.out.println(filename);
                for(int i=0;i<fis.size();i++){
                    fis.get(i).close(); //Извлекаем потоки из списка, чтобы их закрыть
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
