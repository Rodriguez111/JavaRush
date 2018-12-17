package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lst = new ArrayList<>();

        BufferedReader rdr = new BufferedReader(new InputStreamReader(System.in));


        for (int i=0;i<10;i++){
            int a = Integer.parseInt(rdr.readLine());
            lst.add(a);

        }
        int repeart=1;
        int max=1;
        for (int i=0;i<lst.size();i++){

            if(i>0 && lst.get(i)==lst.get(i-1)){repeart++;if(repeart>max){max=repeart;}}
            else {repeart=1;}

        }

        System.out.println(max);

    }
}