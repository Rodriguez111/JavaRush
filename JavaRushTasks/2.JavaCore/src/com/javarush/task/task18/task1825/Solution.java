package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution  {


    public static void main(String[] args) throws IOException {
        //здесь храним созданные потоки чтения из файлов, упорядоченные по имени файла
        TreeMap<String, FileInputStream> fis = new TreeMap();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";

        while (true){
            fileName=br.readLine();

            if(fileName.equals("end")){break;}

           fis.put(fileName, new FileInputStream(fileName));
        }
//читаем имя файла из первой записи мапы, отрезаем суффмкс после последней точки, и получаем файл назначения
   String destinationFile = fis.firstKey().substring(0,fis.firstKey().lastIndexOf("."));

        //true означает возможность дописывать в конец файла
        FileOutputStream fos = new FileOutputStream(destinationFile, true);


        for(Map.Entry<String, FileInputStream> pair:fis.entrySet()){
//создаем буфер для чтения длиной в 1000 байт
byte[] buff = new byte[1000];
            while(pair.getValue().available()>0){

                //получаем количество байт в буфере
                int count = pair.getValue().read(buff);
                fos.write(buff,0,count);

            }
            pair.getValue().close();

        }
        fos.close();

    }
}
