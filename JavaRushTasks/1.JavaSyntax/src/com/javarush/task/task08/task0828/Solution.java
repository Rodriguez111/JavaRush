package com.javarush.task.task08.task0828;


import java.io.IOException;

import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {


        HashMap<Integer, String> year = new HashMap<Integer, String>();
        year.put(1, "January");
        year.put(2, "February");
        year.put(3, "March");
        year.put(4, "April");
        year.put(5, "May");
        year.put(6, "June");
        year.put(7, "July");
        year.put(8, "August");
        year.put(9, "Septrmber");
        year.put(10, "October");
        year.put(11, "November");
        year.put(12, "December");

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
if (year.containsValue(s)){
            for(Map.Entry<Integer, String> p:year.entrySet()){
if(p.getValue().equals(s)){
                System.out.println(s+" is "+p.getKey()+" month");}
            }
}
    }
}
