package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/


import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileName = br.readLine();
        br.close();


        FileReader fr = new FileReader(fileName);
        br = new BufferedReader(fr);

String line;
String str="";
        while ((line = br.readLine())!=null){
            str = str+line;
        }
fr.close();

findAndPrintTag(str,args[0]);



    }


    private static void findAndPrintTag(String sourceString, String tag){

        String openTag="<"+tag;
        String closeTag="</"+tag+">";
        int lengthOfOpenTag = openTag.length();
        int lengthOfCloseTag = closeTag.length();


        String stringToWorkWith=sourceString;

        TreeMap<Integer, Integer> map = new TreeMap();

//ищем индексы открывающих тегов
        int additive=0; //добавка количества символов с начала строки, чтобы индексы искомых выражений имели сквозную нумерауцию по строке
        while (stringToWorkWith.indexOf(openTag)!=-1) {

            map.put(stringToWorkWith.indexOf(openTag)+additive,0);//0 - признак открывающего тега
            additive=additive+stringToWorkWith.indexOf(openTag)+lengthOfOpenTag;//добавляем индекс найденного выражение плюс длина самого этого выражения(lengthOfOpenTag)
            stringToWorkWith = stringToWorkWith.substring(stringToWorkWith.indexOf(openTag)+lengthOfOpenTag);//отрезаем найденное выражение
        }

//ищем индексы закрывающих тегов
        additive=0;//обнуляем добавку
        stringToWorkWith=sourceString; //заново присваиваем переменной строку
        while (stringToWorkWith.indexOf(closeTag)!=-1) {
            map.put(stringToWorkWith.indexOf(closeTag) + additive, 1); //1 - признак закрывающего тега
            additive = additive + stringToWorkWith.indexOf(closeTag) + lengthOfCloseTag;
            stringToWorkWith = stringToWorkWith.substring(stringToWorkWith.indexOf(closeTag) + lengthOfCloseTag);
        }


        int count=0;
        int begin=0; //индекс открывающего тега
        int end=0; //индекс закрывающего тега
        int keyToRemove=0;//переменная, в которую запоминаем ключ для удаления индекса открывающего тега после его использования

        while (map.size()>0) {

            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {

                if (pair.getValue().equals(0)) {//находим первый открывающий тег
                    count++;//привавляем единицу, которая должна отняться при встрече следующего закрывающего тега
                    if (begin == 0) {//присваиваем значение только если текущее значение переменной 0, так как иначе переменная перезаписывается при вложенных тегах

                        begin = pair.getKey();
                        keyToRemove = pair.getKey(); //запоминаем элемент, который больше не нужен, чтобы потом его удалить
                    }
                }
                if (pair.getValue().equals(1)) {//находим соответствующий закрывающий тег для найденного открывающего.
                    count--; //нашли закрывающий тег, => переменная уменьшилась на 1
                    if (count == 0) { //если count снова вернулся к 0, значит мы нашли соответствующий закрывающий тег.
                        end = pair.getKey(); //запомнили индекс закрывающего тега
                        System.out.println(sourceString.substring(begin, end + lengthOfCloseTag)); //вывели на печать найденный тег и его содержимое
                        //end + lengthOfCloseTag - индекс закрывающего тега плюс длина самого этого тега (lengthOfCloseTag)
                        begin = 0; //обнулили переменную, теперь она готова для поиска следующего открывающего тега

                        map.remove(keyToRemove);//удаляем пару с индексом открывающего тега
                        map.remove(end); //удаляем пару с индексом закрывающего тега
                        break; //прерываем цикл.

                    }

                }

            }
        }



    }//конец метода findAndPrintTag()





}
