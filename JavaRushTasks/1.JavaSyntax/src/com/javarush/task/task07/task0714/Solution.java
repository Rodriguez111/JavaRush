package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lst = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        for (int i=0;i<5;i++){
            lst.add(scan.nextLine());
        }

        lst.remove(2);

        for(int i=0;i<lst.size();i++){
            System.out.println(lst.get(lst.size()-i-1));

        }

    }
}


