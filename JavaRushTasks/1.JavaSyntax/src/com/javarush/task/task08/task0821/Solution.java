package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов1","Иван1");
        map.put("Иванов1","Иван2");
        map.put("Иванов3","Иван3");
        map.put("Иванов4","Иван4");
        map.put("Иванов5","Иван5");
        map.put("Иванов5","Иван6");
        map.put("Иванов7","Иван1");
        map.put("Иванов8","Иван2");
        map.put("Иванов9","Иван7");
        map.put("Иванов10","Иван8");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
