package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {


        if (args.length!=0 && args[0].equals("-c")){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            br.close();

            FileInputStream fis = new FileInputStream(fileName);
            br=new BufferedReader(new InputStreamReader(fis,"UTF-8"));

            String line;
            int maxCode=0;
            while ((line=br.readLine())!=null){

if(line.substring(0,8).indexOf(" ")!=-1) {//если код дополнен до 8 символов пробелами
    line = line.substring(0,line.indexOf(" "));
}
else{ //иначе берем с первого по 8 символ
    line = line.substring(0, 8);
}

int code = Integer.parseInt(line); //перобразуем в int
 if (code>maxCode){maxCode=code;} //находим максимальный код
     }
fis.close();
br.close();
     maxCode++;//прибавляем единицу

            FileOutputStream fos = new FileOutputStream(fileName, true) ;


        String code =  String.valueOf(maxCode); //преобразуем код в строку
            while (code.length()<8){ //добавляем пробелы, если длина менее 8 символов
                code=code+" ";
            }
            if (code.length()>8){code=code.substring(0,8);}//обрезаем если длиннее 8 символов

        String name=args[1];
            while (name.length()<30){ //добавляем пробелы, если длина менее 30 символов
                name=name+" ";
            }
            if (name.length()>30){name=name.substring(0,30);}//обрезаем если длиннее 30 символов

            String price=args[2];
            while (price.length()<8){ //добавляем пробелы, если длина менее 8 символов
                price=price+" ";
            }
            if (price.length()>8){price=price.substring(0,8);}//обрезаем если длиннее 8 символов

            String quantity=args[3];
            while (quantity.length()<4){ //добавляем пробелы, если длина менее 4 символов
                quantity=quantity+" ";
            }




            line=""; //обнуляем переменную line
            String lineSeparator = System.getProperty("line.separator"); //инициализируем переводчик строки
            line=code+name+price+quantity;


            fos.write(lineSeparator.getBytes());
            fos.write(line.getBytes());

            fos.close();

        }



    }
}
