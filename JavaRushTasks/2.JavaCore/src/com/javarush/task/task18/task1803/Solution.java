package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferreader.readLine();
        bufferreader.close(); //закрываем поток
        FileInputStream fs = new FileInputStream(fileName);




        List<Integer> byteVol=new ArrayList<>();
        int count=0;

        while(fs.available()>0){
            byteVol.add(fs.read()); //заполняем массив байтами
        }
fs.close(); //закрываем поток


        Map<Integer, Integer> bytes = new HashMap(); //Map  "байт" - "кол-во повторов"

        int repeats=1; //кол-во повторов

        for (int i=0;i<byteVol.size()-1;i++){
            for (int j=i+1;j<byteVol.size();j++){
                if(byteVol.get(i)==byteVol.get(j)){
                    repeats++;
                   byteVol.remove(j);

                }

            }

            bytes.put(byteVol.get(i),repeats);
            repeats=1;

        }


int max=0;

        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
           if(pair.getValue()>max){max=pair.getValue();} //узнаем максимальное кол-во повторов

        }

        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if(pair.getValue()==max){
                System.out.print(pair.getKey()+" ");
            }

        }

    }
}
