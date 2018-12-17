package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        ArrayList words = new ArrayList();

        while (br.ready()){
           String[] line = br.readLine().split(" ");
            for (int i = 0; i<line.length;i++){
                words.add(line[i]);
            }
        }

        StringBuilder word;

        for (int i = 0; i<words.size();i++){
            //помещаем слово в переменную типа StringBuilder:
            word = new StringBuilder(words.get(i).toString());
            //реверсируем слово:
            word = word.reverse();
            //помещаем реверсированное слово в строковую переменную
            // (чтобы сравнивать строку со строкой, иначе мы будем сравнивать строку с объектом):
            String reversedWord = word.toString();
            for (int j = i+1; j<words.size();j++){
                if(reversedWord.equals(words.get(j))){ //если найдено обратное слово
                    Pair newPair = new Pair(); //создаем объект пары и помещаем в него найденные слова
                    newPair.first=words.get(i).toString();
                    newPair.second=reversedWord;

                    if(!result.contains(newPair)){ //если в нашем списке еще нет такой пары, добавляем ее в список
                        result.add(newPair);
                    }
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
