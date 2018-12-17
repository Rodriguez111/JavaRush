package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);


        ArrayList<String> lst = new ArrayList<>();
        while (br.ready()){
            String[] words = br.readLine().split(" ");
            lst.addAll(Arrays.asList(words));
        }

        String[] words = new String[0];
        words = lst.toArray(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }


    public static StringBuilder getLine(String... words) {
        LinkedList<String> listOfWords = new LinkedList<>();
        StringBuilder resultChain = new StringBuilder();

        for(int i=0; i<words.length;i++){
            if(!listOfWords.contains(words[i])){ //проверка на уникальность слов
                listOfWords.add(words[i]);
            }
        }

        for(int i=0; i<listOfWords.size();i++ ){
            LinkedList<String> temp = new LinkedList<>();
            temp.addAll(listOfWords); //передаем список строк во временный список
            StringBuilder chain = new StringBuilder();
            chain.append(" "+temp.get(i)+" "); //добавляем i-тое слово в пустую строку, к которой будем пытаться пристыковать другие
            temp.remove(i); //удаляем вставленное слово

            for (int j=0; j<temp.size();j++ ){
                String candidate = temp.get(j);
                char firstLetter = Character.toLowerCase(candidate.charAt(0));
                char lastLetter = Character.toLowerCase(candidate.charAt(candidate.length()-1));

                char firstSymbolOfString = Character.toLowerCase(chain.charAt(1));
                char lastSymbolOfString = Character.toLowerCase(chain.charAt(chain.length()-2));

                if (firstLetter==lastSymbolOfString){ //если можно пристыковать к концу строки
                    chain.append(candidate+" ");
                    temp.remove(j);
                    j=-1; //начинаем подставлять с начала
                }
                else if(lastLetter==firstSymbolOfString){ //если можно пристыковать к началу строки
                    chain.insert(0," "+candidate);
                    temp.remove(j);
                    j=-1; //начинаем подставлять с начала
                }
            }
            int maxSize = resultChain.length();
            if(chain.length()>maxSize){     //сравниваем длину строки, и выбираем самую длинную
             resultChain=new StringBuilder(chain.toString().trim()); //обрезаем пробелы по краям
            }
        }
        return resultChain;
    }
}
