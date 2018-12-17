package com.javarush.task.task18.task1805;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileInputStream fs = new FileInputStream(fileName);
        File file = new File(fileName);
        TreeSet<Integer> bytesSet = new TreeSet<>();

        int count = 0;
        while (fs.available() > 0) {
            bytesSet.add(fs.read());
        }
        fs.close();


        Iterator iterator = bytesSet.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }




    }
}
