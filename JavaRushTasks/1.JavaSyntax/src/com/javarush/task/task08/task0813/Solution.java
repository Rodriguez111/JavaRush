package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        HashSet<String> s = new HashSet<>();

        for (int i=0;i<20;i++){
            s.add("Л"+"слово"+i);
        }

return s;
    }

    public static void main(String[] args) {

        //System.out.println(Solution.createSet());

    }
}
