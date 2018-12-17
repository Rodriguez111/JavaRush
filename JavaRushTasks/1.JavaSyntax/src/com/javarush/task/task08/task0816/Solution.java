package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("DECEMBER 2 1980"));
        map.put("Stallone1", new Date("JUNE 2 1980"));
        map.put("Stallone2", new Date("JULY 18 1980"));
        map.put("Stallone3", new Date("JANUARY 1 1980"));
        map.put("Stallone4", new Date("FEBRUARY 1 1980"));
        map.put("Stallone5", new Date("March 1 1980"));
        map.put("Stallone6", new Date("April 1 1980"));
        map.put("Stallone7", new Date("AUGUST 1 1980"));
        map.put("Stallone8", new Date("NOVEMBER 1 1980"));
        map.put("Stallone9", new Date("DECEMBER 1 1980"));



        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {


        Iterator<Date> it1 = map.values().iterator();
        while (it1.hasNext()){
            int m = it1.next().getMonth();
            if(m>4&&m<8)it1.remove();
        }

    }

    public static void main(String[] args) {


        //Solution.removeAllSummerPeople(Solution.createMap());
    }
}
