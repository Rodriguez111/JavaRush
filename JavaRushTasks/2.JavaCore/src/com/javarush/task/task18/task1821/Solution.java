package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;



public class Solution {
    public static void main(String[] args) throws IOException {





        FileInputStream fis = new FileInputStream(args[0]);

        List bytes = new ArrayList();



       while (fis.available()>0){
           bytes.add(fis.read());
       }
        fis.close();

        Map treeMap = new TreeMap<>();
        int symbolOccurs=1;//сколько раз встречается символ
  for(int i=0;i<bytes.size();i++){

            for (int j = i+1; j < bytes.size(); j++) {
               if(bytes.get(i)==bytes.get(j)) {
                   symbolOccurs++; //увеличиваем кол-во встречаний
                   bytes.remove(j); //удаляем встретившийся еще раз символ
                   j--; //уменьшаем шаг на 1

               }

            }
      treeMap.put(bytes.get(i), symbolOccurs);
      symbolOccurs=1;
        }
        Iterator entries = treeMap.entrySet().iterator();

        while (entries.hasNext()) {

        Map.Entry entry = (Map.Entry) entries.next();
        int symbolCode=(int)entry.getKey();
        System.out.println((char)symbolCode+" "+ entry.getValue());


        }



    }
}
