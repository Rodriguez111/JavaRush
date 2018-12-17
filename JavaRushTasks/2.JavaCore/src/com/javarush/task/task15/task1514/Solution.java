package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static{
        labels.put(1.1, "ewrt");
        labels.put(1.2, "456");
        labels.put(1.3, "ert");
        labels.put(1.4, "etuoip;86");
        labels.put(1.5, "dfghnmkj");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
