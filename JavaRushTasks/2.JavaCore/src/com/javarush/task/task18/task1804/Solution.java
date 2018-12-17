package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fs = new FileInputStream(fileName);

        ArrayList<Integer> arr = new ArrayList<>();
        while(fs.available()>0){
            arr.add(fs.read());
        }
        fs.close();

        HashMap<Integer, Integer> repeatMap = new HashMap();
        for (int i=0;i<arr.size();i++){
         repeatMap.put(arr.get(i),Collections.frequency(arr,arr.get(i))); //Частота повторений в списке
        }

        int min=arr.size();
        for(HashMap.Entry<Integer, Integer> pair:repeatMap.entrySet()){
            if(pair.getValue()<min){min=pair.getValue();}
        }

        for(HashMap.Entry<Integer, Integer> pair:repeatMap.entrySet()){
            if (pair.getValue()==min){
                System.out.print(pair.getKey()+" ");
            }
        }

    }
}
