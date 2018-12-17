package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Иванов", "Иван" );
        map.put("Петров", "Петр" );
        map.put("Сидоров", "Сидор" );
        map.put("Николаев", "Николай" );
        map.put("Семенов", "Иван" );
        map.put("Семенов1", "Семен1" );
        map.put("Петров1", "Петр1" );
        map.put("Иванов5", "Иван5" );
        map.put("Олегов", "Олег" );
        map.put("Романов", "Николай" );
        return map;

    }
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> mapTemp=new HashMap<>(map);//создаем еще один мап, куда копируем исходный

        Iterator<Map.Entry<String,String>> iter = mapTemp.entrySet().iterator();
        HashSet<String> temp = new HashSet<>();
        while (iter.hasNext()){
            Map.Entry<String, String> pair = iter.next();

           if(!temp.add(pair.getValue())) {
              removeItemFromMapByValue(map,pair.getValue());

           }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());

        }


    }

    public static void main(String[] args) {

    }
}
