package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();


        br = new BufferedReader(new FileReader(fileName));
String str;

        while (br.ready()){

           str = br.readLine();

           str=str.replaceAll("[^A-zА-я ]","");//удаляем  любые символы, кроме букв латинского и кириллицы, а так же пробела
            String[] stringArray = str.split(" ");

            int coincidence=0;//количество совпадений

            for(int i=0;i<words.size();i++){
                for(int j=0;j<stringArray.length;j++){
                    if(words.get(i).equals(stringArray[j])){
                        coincidence++;
                    }

                }


            }

            if(coincidence==2){
                System.out.println(str);
            }
            coincidence=0;

        }


        br.close();




    }
}
