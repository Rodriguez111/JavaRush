package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};


        Integer[] sortedArray = sort(array);

//        for(Integer rrr: sortedArray){
//            System.out.println(rrr);
//
//
//
//        }




    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here


        Arrays.sort(array);


       //ищем медиану:
       int mediana = 0;
        if(array.length%2!=0){
          int  medianaIndex = (array.length-1)/2;
            mediana = array[medianaIndex];
        }
        else{
            mediana =  (array[array.length/2]+ array[(array.length/2)-1])/2;
        }

final int ourMediana = mediana;


        Comparator<Integer> compareByMediana = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int result;
                //сравниваем абсолютные величины разницы между сравниваемыми числами массива и медианой
                result = (Math.abs(o1-ourMediana))-(Math.abs(o2-ourMediana));
                //если разница равна, сравниваем сами числа
                if (result == 0)
                    result = o1.compareTo(o2);
                return result;
            }
        };

        Arrays.sort(array, compareByMediana);

        return array;
    }
}
