package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> list = new TreeMap<>();
        double maxSum=0;

        while (br.ready()){
            String[] str = br.readLine().split(" ");

            if(list.containsKey(str[0])){
                list.put(str[0], list.get(str[0])+Double.parseDouble(str[1]));
                if(list.get(str[0])>maxSum){ //если значение больше максимального, записываем его как максимальное
                    maxSum=list.get(str[0]);
                }
            }
            else {
                list.put(str[0],Double.parseDouble(str[1]));
                if(Double.parseDouble(str[1])>maxSum){ //если значение больше максимального, записываем его как максимальное
                   maxSum=Double.parseDouble(str[1]);
                }
            }

        }

        br.close();

        for(Map.Entry<String, Double> pair:list.entrySet()){

            if(pair.getValue()==maxSum) {
                System.out.println(pair.getKey());
            }
        }


    }
}
