package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> m = new HashMap<>();
        m.put("Иванов1",1000);
        m.put("Иванов2",400);
        m.put("Иванов3",300);
        m.put("Иванов4",1200);
        m.put("Иванов5",9000);
        m.put("Иванов6",550);
        m.put("Иванов7",100);
        m.put("Иванов8",1300);
        m.put("Иванов9",8500);
        m.put("Иванов10",700);

        return m;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> mTemp = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair:mTemp.entrySet() ) {
            if (pair.getValue() < 500) {

                map.remove(pair.getKey());

            }

        }

    }



    public static void main(String[] args) {


    }
}