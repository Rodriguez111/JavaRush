package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        String line="";
        TreeMap<String, Double> list = new TreeMap<>();
        String lastName;
        double sum;
        while ((line=br.readLine())!=null){

            lastName=line.substring(0,line.indexOf(" "));
            sum = Double.parseDouble(line.substring(line.indexOf(" ")+1));

            if(list.containsKey(lastName)){//если в мап уже есть такой ключ, изменяем для него значение
                list.put(lastName,list.get(lastName)+sum);
            }
            else{
            list.put(lastName, sum);
            }

        }
fr.close();


        for(Map.Entry<String, Double> pair:list.entrySet()){

            System.out.println(pair.getKey()+" "+pair.getValue());

        }

    }
}
