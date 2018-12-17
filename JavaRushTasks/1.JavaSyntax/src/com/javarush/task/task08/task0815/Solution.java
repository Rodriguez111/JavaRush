package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> m = new HashMap<>();

        m.put("Иванов", "Иван");
        m.put("Петров", "Петр");
        m.put("Сидоров", "Сидор");
        m.put("Алексеев", "Алексей");
        m.put("Васильев", "Василий");
        m.put("Иванов1", "Петр");
        m.put("Петров1", "Иван");
        m.put("Евгеньев", "Евгений");
        m.put("Олегов", "Олег");
        m.put("Эдуардов", "Эдуард");

        return m;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
       int count=0;
        for(String n:map.values()) {

            if(n==name)count++;

       }
       return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count=0;

        for(String n:map.keySet()) {

            if(n==lastName)count++;



        }
//count=(map.containsKey(lastName)?1:0);

        return count;

    }

    public static void main(String[] args) {
       // System.out.println(Solution.getCountTheSameLastName(Solution.createMap(),"Петров"));
    }
}
