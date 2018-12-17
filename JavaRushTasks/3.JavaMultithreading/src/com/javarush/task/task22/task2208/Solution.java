package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap()  ;
        map.put("name", "Ivanov");
       // map.put("country", "Ukraine");
        //map.put("city", "Kiev");
        map.put("age", null);


        System.out.println(getQuery(map));;


    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String, String> pair: params.entrySet()){

            if(pair.getValue() != null) {
                String param = pair.getKey() + " = '" + pair.getValue() + "'";
                sb = sb.append(param);
                sb = sb.append(" and ");
            }
        }

        if(sb.length()>5) { //на случай если все значения равны null
            sb.delete(sb.length() - 5, sb.length());//отсекаем последнее " and "
        }
        String result = sb.toString();

        return result;
    }
}
