package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map=new HashMap <String, Integer>();

        while (true) {
            String scan=reader.readLine();
            if(scan.equals(""))break;
            int id = Integer.parseInt(scan);
            String name = reader.readLine();
            map.put(name,id);
        }

        for (Map.Entry<String, Integer> p:map.entrySet()
             ) {
            System.out.println(p.getValue()+" "+p.getKey());
        }
    }
}
