package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        if(reader == null)return "";

BufferedReader br = new BufferedReader(reader);

        ArrayList<Character> list = new ArrayList<>();

        int nextChar = br.read();

        String result = "";

        while ( nextChar >0 ){

            result = result+(char) (nextChar+key);
            nextChar = br.read();
        }



        return result;
    }
}
