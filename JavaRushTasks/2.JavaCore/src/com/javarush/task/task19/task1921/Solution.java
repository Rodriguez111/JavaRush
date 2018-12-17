package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str;
        String name;
        String date;
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

        while (reader.ready()){
            str=reader.readLine();

            char[] charArray = str.toCharArray();
            int indexOfFirstDigit=0;
            for(int i=0;i<charArray.length;i++){//определяем позицию первой цифры в строке
                if(Character.isDigit(charArray[i])){
                    indexOfFirstDigit=i;
                    break;
                }
            }

           name= str.substring(0,indexOfFirstDigit-1);
           date=str.substring(indexOfFirstDigit);
            PEOPLE.add(new Person(name,format.parse(date) ));

        }
        reader.close();




    }
}
